public class SalesPerson {
    private String id;
    private String name;
    private double grossSales;
    private double commissionRate;

    private Order[] orderArray = new Order[3];
    private int orderCount = 0;

    public SalesPerson(String id, String name) {
        //預設commissionRate = 0.01
        this.id = id;
        this.name = name;
        this.commissionRate = 0.01;  // 預設獎金比例
    }

    public SalesPerson(String id, String name, double commissionRate) {
        this.id = id;
        this.name = name;
        this.commissionRate = commissionRate;
    }

    public String getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public void setCommissionRate(double commissionRate) {
        this.commissionRate = commissionRate;
    }

    public void setOrderArray(String itemName, double itemPrice, int amount) {
        //*************************
        //(加分項)若陣列長度不足，將陣列長度x2
        //(必要)新增order到orderList
        //*************************
        // 如果陣列容量不足，擴展陣列
        if (orderCount == orderArray.length) {
            Order[] newOrderArray = new Order[orderArray.length * 2];
            System.arraycopy(orderArray, 0, newOrderArray, 0, orderArray.length);
            orderArray = newOrderArray;
        }
        // 新增訂單
        orderArray[orderCount] = new Order(itemName, itemPrice, amount);
        orderCount++;
    }

    public double getGrossSales() {
        //*************************
        //計算總銷售額，並回傳
        //*************************

        double total = 0;
        for (int i = 0; i < orderCount; i++) {
            total += orderArray[i].totalSale();
        }
        return total;
    }

    
    public String getOrders() {
        
        //****************************************
        //將所有oder的內容，整合為一個字串，並回傳
        //****************************************
        StringBuilder orders = new StringBuilder();
        for (int i = 0; i < orderCount; i++) {
            orders.append(orderArray[i].toString());
        }
        return orders.toString();
    }


    
    public double salary() {
       //****************************************
        //利用getGrossSales()計算薪資
        //****************************************
        return getGrossSales() * commissionRate;
    }

    public String toString() {
        return String.format("業務員編號：%s%n業務員姓名：%s%n銷售金額：%.1f%n獎金比例：%.2f%n薪資：%.1f%n",
                this.id, this.name, this.grossSales, this.commissionRate, salary() );
    }
}
