public class SalesPerson {
    private String id;
    private String name;
    private double grossSales;
    private double commissionRate;

    public SalesPerson(String id, String name) {
        //呼叫下一個的建構子
        this(id,name,0,0.01);


    }

    public SalesPerson(String id, String name, double grossSales, double commissionRate) {
        // grossSales & commissionRate的設定須呼叫set方法
        this.id = id;
        this.name = name;
        setGrossSales(grossSales);  // 呼叫set方法以設定grossSales
        setCommissionRate(commissionRate);  // 呼叫set方法以設定commissionRate

    }

    public String getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public void setGrossSales(double grossSales) {
        //檢查銷售金額必須為正值!
        if (grossSales > 0) {
            this.grossSales = grossSales;
        } else {
            System.out.println("銷售金額必須為正值！");
        }
    }

    public void setCommissionRate(double commissionRate) {
        //檢查獎金比例必須為0~1!
        if (commissionRate >= 0 && commissionRate <= 1) {
            this.commissionRate = commissionRate;
        } else {
            System.out.println("獎金比例必須介於0和1之間！");
        }
    }

    public double salary() {
        //薪資為銷售額乘上分紅比
        return this.grossSales * this.commissionRate;
    }

    public String toString() {
        return String.format("業務員編號：%s%n業務員姓名：%s%n銷售金額：%.1f%n獎金比例：%.2f%n薪資：%.1f%n",
                this.id, this.name, this.grossSales, this.commissionRate, salary() );
    }
}
