class movieTickets {
    constructor() {
        this.tickets = [];
    }

    addTicket(movieName, seatType, ticketPrice, quantity) {
        const ticket = {
            movieName,
            seatType,
            ticketPrice,
            quantity
        };

        this.tickets.push(ticket);
    }

    removeTicket(movieName) {
        this.tickets = this.tickets.filter(
            ticket => ticket.movieName !== movieName
        );
    }

    calculateTotalAmount() {
        let totalAmount = 0;

        this.tickets.forEach(ticket => {
            totalAmount += ticket.ticketPrice * ticket.quantity;
        });

        return totalAmount;
    }

    applyOffer(code) {
        const total = this.calculateTotalAmount();

        const offers = {
            OFFER10: 0.10,
            OFFER20: 0.20,
            OFFER30: 0.30
        };

        if (offers[code]) {
            return total - (total * offers[code]);
        }

        return total;
    }

    calculateEntertainmentTax(taxrate) {
        const total = this.calculateTotalAmount();
        return total * taxrate;
    }

    finalBooking(offerCode = null, taxrate = 0) {
        let total = this.calculateTotalAmount();

        if (offerCode) {
            total = this.applyOffer(offerCode);
        }

        const tax = total * taxrate;
        const finalAmount = total - tax;

        this.tickets = [];

        return finalAmount;
    }
}

module.exports = movieTickets;