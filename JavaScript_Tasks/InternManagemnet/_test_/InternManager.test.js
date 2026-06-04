
const InternManager = require("../internManager");
describe("Intern Management System", () => {
    let manager;
    beforeEach(() => {
        manager = new InternManager();
    });
    test("should add intern", () => {
        manager.addIntern("Sakshi", "Java", 10000, 2);
        expect(manager.interns.length).toBe(1);
    });
    test("should remove intern", () => {
        manager.addIntern("Sakshi", "Java", 10000, 2);
        manager.removeIntern("Sakshi");
        expect(manager.interns.length).toBe(0);
    });
    test("should calculate total stipend", () => {
        manager.addIntern("A", "Java", 10000, 2);
        manager.addIntern("B", "Python", 15000, 1);
        expect(manager.calculateTotalStipend()).toBe(35000);
    });
    test("should apply bonus", () => {
        manager.addIntern("A", "Java", 10000, 2);
        expect(manager.applyBonus("BONUS10")).toBe(22000);
    });
    test("should calculate tax", () => {
        manager.addIntern("A", "Java", 10000, 2);
        expect(manager.calculateTax(0.10)).toBe(2000);
    });
    test("should complete payout and clear interns", () => {
        manager.addIntern("A", "Java", 10000, 2);
        const result = manager.payout("BONUS10", 0.10);
        expect(result).toBe(20000);
        expect(manager.interns.length).toBe(0);
    });
});