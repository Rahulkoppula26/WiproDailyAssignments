class InternManager {
    constructor() {
        this.interns = [];
    }
    addIntern(name, department, stipend, months) {
        const intern = {
            name,
            department,
            stipend,
            months
        };
        this.interns.push(intern);
    }
    removeIntern(name) {
        this.interns = this.interns.filter(
            intern => intern.name !== name
        );
    }
    calculateTotalStipend() {
        let total = 0;
        this.interns.forEach(intern => {
            total += intern.stipend * intern.months;
        });
        return total;
    }
    applyBonus(code) {
        const total = this.calculateTotalStipend();
        const bonuses = {
            BONUS10: 0.10,
            BONUS20: 0.20,
            BONUS30: 0.30
        };
        if (bonuses[code]) {
            return total + (total * bonuses[code]);
        }
        return total;
    }
    calculateTax(taxRate) {
        const total = this.calculateTotalStipend();
        return total * taxRate;
    }
    payout(bonusCode = null, taxRate = 0) {
        let total = this.calculateTotalStipend();
        if (bonusCode) {
            total = this.applyBonus(bonusCode);
        }
        const tax = this.calculateTax(taxRate);
        const finalAmount = total - tax;
        this.interns = [];
        return finalAmount;
    }
}
module.exports = InternManager;