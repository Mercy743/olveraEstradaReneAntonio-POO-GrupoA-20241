package tarea_5_u2;


public class Taxes {
     public double taxCalculator(int earnings) {
        return earnings + 0.15;
    }

    public double taxCalculator(double sales, double taxPercentage) {
        return sales*(taxPercentage / 100);
    }

    public double taxCalculator(double dividends, double taxPercentage, double dispensary) {
        double taxes = dividends * (taxPercentage / 100);
        if (taxes > dispensary) {
            return taxes - dispensary;
        } else {
            return 0;
        }
    }

}
