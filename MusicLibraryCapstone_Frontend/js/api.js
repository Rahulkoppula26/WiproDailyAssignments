


const API_BASE = window.API_BASE || "http://localhost:9000";
// const ADMIN_SONGS_URL = `${API_BASE}/users/songs`;
const ADMIN_SONGS_URL = `${API_BASE}/admin/songs`;

const USER_PLAYLISTS_URL = `${API_BASE}/users/playlists`;

const ADMIN_USERS_URL = `${API_BASE}/admin/users`;

const NOTIFICATIONS_URL = `${API_BASE}/notifications`;



/**
 * Reads JWT token from localStorage and returns it in raw form.
 * - Accepts either a stored raw token or a token prefixed with "Bearer ".
 *
 * @returns {string|null} Token string without "Bearer " prefix, or null if not found.
 */
function getToken() {
  let token = localStorage.getItem("jwt_token");

  if (!token) return null;

  token = token.trim();

  if (token.startsWith("Bearer ")) {
    token = token.substring(7);
  }

  return token;
}

/**
 * Builds request headers for authenticated API calls.
 * Uses the token from localStorage.
 *
 * @returns {Object} Headers object. Includes Authorization when token exists.
 */
function authHeaders() {
  const token = getToken();

  return token
    ? { Authorization: `Bearer ${token}` }
    : {};
}


/**
 * Clears all authentication-related items from localStorage
 * and redirects the user back to the login page.
 */
function logout() {
  localStorage.removeItem("jwt_token");
  localStorage.removeItem("token");
  localStorage.removeItem("Authorization");
  localStorage.removeItem("user_role");
  localStorage.removeItem("user_id");
  localStorage.removeItem("userId");
  localStorage.removeItem("id");
  localStorage.removeItem("username");

  window.location.href = "index.html";
}


/**
 * Fetches the current logged-in user's profile from the backend.
 *
 * @returns {Promise<any>} Profile data returned by the API.
 * @throws {Error} When the API request fails.
 */
async function getUserProfile() {
  return apiFetch(`${API_BASE}/auth/profile`, {
    headers: authHeaders()
  });
}




/**
 * Returns the user role stored in localStorage.
 *
 * @returns {string|null} Role string (e.g., "ROLE_ADMIN") or null if not set.
 */
function getRole() {
  return localStorage.getItem("user_role");
}


/**
 * Attempts to read the current user's id from localStorage.
 * Supports multiple possible key names used across the project.
 *
 * @returns {string|null} User id as stored, or null when not available.
 */
function getUserId() {
  return localStorage.getItem("user_id") || localStorage.getItem("userId") || localStorage.getItem("id");
}





/**
 * Builds headers for JSON requests (Content-Type + Authorization when available).
 *
 * @returns {Object} Headers for JSON APIs.
 */
function jsonHeaders() {
  return { "Content-Type": "application/json", ...authHeaders() };
}



// Access Control Helpers
function requireAuth() {
  if (!getToken()) {
    window.location.href = "index.html";
    return false;
  }
  return true;
}


// Access Control Helpers
  function requireUser() {
    if (!requireAuth()) return false;
    if (getRole() === "ROLE_ADMIN") {
      window.location.href = "admin-dashboard.html";
      return false;
    }
    return true;
  }

  
   function requireAdmin() {
    if (!requireAuth()) return false;
    if (getRole() !== "ROLE_ADMIN") {
      window.location.href = "dashboard.html";
      return false;
    }
    return true;
  }


   async function safeJson(res) {
    const text = await res.text();
    try {
      return text ? JSON.parse(text) : null;
    } catch {
      return text;
    }
  }



  async function apiFetch(url, options = {}) {
    const res = await fetch(url, options);
    const data = await safeJson(res);
    if (!res.ok) {
      throw new Error(typeof data === "string" ? data : data?.message || "Request failed");
    }
    return data;
  }



// UI Helpers  
   function setupShell(name = "User") {
    document
      .getElementById("menuToggle")
      ?.addEventListener("click", () =>
        document.getElementById("sidebar")?.classList.toggle("active"),
      );

    document.getElementById("logoutBtn")?.addEventListener("click", (e) => {
      e.preventDefault();
      logout();
    });

    const u = localStorage.getItem("username") || name;
    const el = document.getElementById("userName");
    if (el) el.textContent = u;

    const av = document.getElementById("userAvatar");
    if (av) av.textContent = (u || name || "U")[0].toUpperCase();
  }
// Simple function to show a toast notification using Bootstrap's Toast component
   function showToast(message) {
    document.getElementById("toastMessage").textContent = message;

    const toast = new bootstrap.Toast(
      document.getElementById("liveToast")
    );

    toast.show();
  }

// Loads notifications and updates the badge count in the UI
   async function loadNotificationCount() {
    try {
      const notifications = await getNotifications();
      const badge = document.getElementById("notifBadge");
      if (badge) badge.textContent = notifications.length;
    } catch (e) {
      console.error(e);
    }
  }


// Notification
  async function showNotifications() {
    const list = document.getElementById("notificationsList");

// Fetch notifications and render them in the modal, with error handling and fallback UI
    try {
      const notifications = await getNotifications();

      if (list) {
        list.innerHTML =
          notifications.map(n => `
          <div class="notification-item">
            <div class="notification-icon">
              <i class="fas fa-music"></i>
            </div>
            <div>
              <h6>${escapeHtml(n.title)}</h6>
              <p>${escapeHtml(n.message)}</p>
              <small>${escapeHtml(new Date(n.createdAt).toLocaleString())}</small>
            </div>
          </div>
        `).join("") ||
          `<div class="empty-state">
          <i class="fas fa-bell"></i>
          <h3>No notifications</h3>
          <p>You are all caught up.</p>
        </div>`;
      }
// Update badge count after loading notifications
      const badge = document.getElementById("notifBadge");
      if (badge) badge.textContent = notifications.length;

    } catch (e) {
      console.error(e);
      if (list) {
        list.innerHTML = `<p class="text-danger">Unable to load notifications</p>`;
      }
    }

    const modal = document.getElementById("notificationsModal");
    if (modal && window.bootstrap) {
      new bootstrap.Modal(modal).show();
    }
  }



// Utility functions to safely extract song details with fallbacks and handle different data shapes
   function escapeHtml(v) {
    return String(v ?? "").replace(/[&<>'"]/g, (c) =>
        ({ "&": "&amp;", "<": "&lt;", ">": "&gt;", "'": "&#39;", '"': "&quot;" })[c],
    );
  }

//  Functions to extract song details with multiple fallback keys and default values
   function songTitle(song) {
    return song?.songName || song?.name || song?.title || "Unknown Song";
  }

  // Functions to extract singer/artist details with multiple fallback keys and default values
   function songSinger(song) {
    return song?.artistSinger || song?.singer || song?.artist || "Unknown Artist";
  }

//  Functions to extract album details with multiple fallback keys and default values
  function songAlbum(song) {
    return song?.albumMovieName || song?.album || song?.albumName || "Music Library";
  }

// Functions to determine song visibility based on multiple possible keys in the data
  function songVisible(song) {
    return Boolean(song?.visibility ?? song?.visible ?? song?.isVisible);
  }

// Functions to extract playlist name with multiple fallback keys and default value
  function playlistName(p) {
    return p?.playlistName || p?.name || "Untitled Playlist";
  }


  //  Utility function to normalize API responses that may return arrays directly or wrapped in various keys
  function normalizeArray(data, ...keys) {
    if (Array.isArray(data)) return data;
    for (const key of keys) {
      if (Array.isArray(data?.[key])) return data[key];
    }
    return [];
  }
// Fetches visible songs, with fallback to client-side filtering if the API doesn't support it
 async function getVisibleSongs() {
    try {
      return normalizeArray(await apiFetch(`${ADMIN_SONGS_URL}/visible`, { headers: authHeaders() }), "songs", "items");
    } catch {
      const all = normalizeArray(await apiFetch(ADMIN_SONGS_URL, { headers: authHeaders() }), "songs", "items");
      return all.filter(songVisible);
    }
  }

// Fetches all songs for admin view, without filtering, and normalizes the response format
  async function getAllSongsAdmin() {
    return normalizeArray(await apiFetch(ADMIN_SONGS_URL, { headers: authHeaders() }), "songs", "items");
  }
// Fetches all users for admin view, without filtering, and normalizes the response format
async function getAllUsersAdmin() {
  return normalizeArray(
    await apiFetch(ADMIN_USERS_URL, { headers: authHeaders() }),
    "users",
    "items",
    "data",
  );
}
//  Adds a new user via the admin API, sending the user data as JSON in the request body
async function addUserAdmin(user) {
  return apiFetch(ADMIN_USERS_URL, {
    method: "POST",
    headers: jsonHeaders(),
    body: JSON.stringify(user),
  });
}
// Updates an existing user via the admin API, sending the updated user data as JSON in the request body
async function updateUserAdmin(userId, user) {
  return apiFetch(`${ADMIN_USERS_URL}/${userId}`, {
    method: "PUT",
    headers: jsonHeaders(),
    body: JSON.stringify(user),
  });
}
// Deletes a user via the admin API, specifying the user ID in the URL and using the DELETE method
async function deleteUserAdmin(userId) {
  return apiFetch(`${ADMIN_USERS_URL}/${userId}`, {
    method: "DELETE",
    headers: authHeaders(),
  });
}
// Fetches the current user's playlists, optionally filtering by user ID if available, and normalizes the response format

async function getMyPlaylists() {
  const uid = getUserId();
  const url = uid ? `${USER_PLAYLISTS_URL}/user/${uid}` : USER_PLAYLISTS_URL;
  const res = await apiFetch(url, { headers: authHeaders() });

  // Backend can return either:
  // - []
  // - { playlists: [] }
  // - { items: [] }
  // - { data: [] }
  if (Array.isArray(res)) return res;
  return normalizeArray(res, "playlists", "items", "data");
}
// Deletes a user playlist by ID, sending a DELETE request to the appropriate API endpoint with authentication headers
async function deleteUserPlaylist(playlistId) {
  if (!playlistId) throw new Error("playlistId is required");
  return apiFetch(`${USER_PLAYLISTS_URL}/${playlistId}`, {
    method: "DELETE",
    headers: authHeaders(),
  });
}
//  Creates a new user playlist with the given name, sending a POST request to the API with 
// the playlist details in the request body
async function createUserPlaylist(name) {
  const payload = {
    playlistName: name,
    userId: getUserId() ? Number(getUserId()) : 1,
    visibility: true,
    songs: []
  };
  return apiFetch(USER_PLAYLISTS_URL, {
    method: "POST",
    headers: jsonHeaders(),
    body: JSON.stringify(payload),
  });
}
// Adds a song to a user playlist by sending a POST request to the API endpoint that includes both 
// the playlist ID and song ID, along with authentication headers
async function addSongToPlaylist(playlistId, songId) {
  return apiFetch(`${USER_PLAYLISTS_URL}/${playlistId}/songs/${songId}`, {
    method: "POST",
    headers: authHeaders(),
  });
}
// Removes a song from a user playlist by sending a DELETE request to the API endpoint 
// that includes both the playlist ID and song ID, along with authentication headers
async function removeSongFromPlaylist(playlistId, songId) {
  return await apiFetch(`${USER_PLAYLISTS_URL}/${playlistId}/songs/${songId}`, {
    method: 'DELETE',
    headers: authHeaders()
  });
}
// Fetches notifications for the current user, normalizing the response to handle different possible formats returned by the API
async function getNotifications() {
  return normalizeArray(
    await apiFetch(NOTIFICATIONS_URL, { headers: authHeaders() }),
    "notifications",
    "items",
    "data"
  );
}
