
// Hospital Patient Billing System
// Features

// Each patient:
// patientName
// treatmentType
// treatmentCost
// days

// addPatient() 1
// removePatient() 2 
// calculateTotalBill() 3
 // applyInsuranceDiscount() 4
// calculateMedicalTax() 5
// finalBilling() 6



class BillingSystem{
    constructor(){
        this.patients = [];
    }
    addPatient(patientName,treatmentType,treatmentCost,days){
        const patient  = {
            patientName,
            treatmentType,
            treatmentCost,
            days
        };
        this.patients.push(patient);
        
    }
    removePatient(patientName){
        this.patients = this.patients.filter(
            patient => patient.patientName !== patientName
        );
    }
    calculateTotalBill(){
        let totalBill = 0;
        this.patients.forEach( patient => {
            if(patient)
            totalBill += patient.treatmentCost * patient.days;
        });
        return totalBill;
         
    }
    applyInsuranceDiscount(code){
        const total = this.calculateTotalBill();
        const discount = {
            DISCOUNT10 : 0.10,
            DISCOUNT20 : 0.20,
            DISCOUNT30 : 0.30,
        };
        if(discount[code]){
            return total - (total * discount[code]);
        }
        return total;
    }
    calculateMedicalTax(taxrate){
        const total = this.calculateTotalBill();
        return total*taxrate;
    }
    finalBilling(discountCode= null,taxrate =0){
        let total = this.calculateTotalBill();
         if (discountCode) {
            total = this.applyInsuranceDiscount(discountCode);
        }
        const tax = total * taxrate;

        const finalAmount = total - tax;
        this.patients = [];
        return finalAmount;
    }


}

module.exports = BillingSystem;