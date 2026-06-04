const TicketBookingSystem = require("../movieTickets");

describe("Movie Ticket Booking System", () => {
    let booking;

    beforeEach(() => {
        booking = new TicketBookingSystem();
    });

    test("should add ticket", () => {
        booking.addTicket("Avatar", "Premium", 500, 2);

        expect(booking.tickets.length).toBe(1);
        expect(booking.tickets[0].movieName).toBe("Avatar");
    });

    test("should remove ticket", () => {
        booking.addTicket("Avatar", "Premium", 500, 2);
        booking.addTicket("RRR", "Normal", 300, 3);

        booking.removeTicket("Avatar");

        expect(booking.tickets.length).toBe(1);
        expect(booking.tickets[0].movieName).toBe("RRR");
    });

    test("should calculate total amount", () => {
        booking.addTicket("Avatar", "Premium", 5000, 2);
        booking.addTicket("RRR", "Normal", 3000, 1);

        expect(booking.calculateTotalAmount()).toBe(13000);
    });

    test("should apply offer", () => {
        booking.addTicket("Avatar", "Premium", 5000, 2);

        expect(booking.applyOffer("OFFER10")).toBe(9000);
    });

    test("should calculate entertainment tax", () => {
        booking.addTicket("Avatar", "Premium", 5000, 2);

        expect(booking.calculateEntertainmentTax(0.10)).toBe(1000);
    });

    test("should complete final booking and clear tickets", () => {
        booking.addTicket("Avatar", "Premium", 5000, 2);

        const result = booking.finalBooking("OFFER10", 0.10);

        expect(result).toBe(8100);
        expect(booking.tickets.length).toBe(0);
    });
});