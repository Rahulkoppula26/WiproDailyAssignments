const BillingSystem = require("../BillingSystem");

describe("Hospital Patient Billing System", () => {
    let billing;

    beforeEach(() => {
        billing = new BillingSystem();
    });

    test("should add patient", () => {
        billing.addPatient("Ravi", "Surgery", 5000, 3);

        expect(billing.patients.length).toBe(1);
    });

    test("should remove patient", () => {
        billing.addPatient("Ravi", "Surgery", 5000, 3);

        billing.removePatient("Ravi");

        expect(billing.patients.length).toBe(0);
    });

    test("should calculate total bill", () => {
        billing.addPatient("A", "Surgery", 5000, 2);
        billing.addPatient("B", "Therapy", 3000, 1);

        expect(billing.calculateTotalBill()).toBe(13000);
    });

    test("should apply insurance discount", () => {
        billing.addPatient("A", "Surgery", 5000, 2);

        // Total = 10000
        // 10% discount => 9000
        expect(billing.applyInsuranceDiscount("DISCOUNT10")).toBe(9000);
    });

    test("should calculate medical tax", () => {
        billing.addPatient("A", "Surgery", 5000, 2);

        // Total = 10000
        // Tax 10% => 1000
        expect(billing.calculateMedicalTax(0.10)).toBe(1000);
    });

    test("should complete final billing and clear patients", () => {
        billing.addPatient("A", "Surgery", 5000, 2);

        // Total = 10000
        // Discount 10% => 9000
        // Tax 10% => 900
        // Final = 8100

        const result = billing.finalBilling("DISCOUNT10", 0.10);

        expect(result).toBe(8100);

        expect(billing.patients.length).toBe(0);
    });
});