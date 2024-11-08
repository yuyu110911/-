import java.util.Scanner;

public class SalesDepartment {
    public  static void main(String args[]) {
        SalesPerson[] salesTeam = new SalesPerson[3];
        SalesPerson sales1 = new SalesPerson("SE111", "林俊傑");
        SalesPerson sales2 = new SalesPerson("SE222", "張佳豪");
        SalesPerson sales3 = new SalesPerson("SE333", "劉威廷");
        salesTeam[0] = sales1;
        salesTeam[1] = sales2;
        salesTeam[2] = sales3;
        operation(salesTeam);
    }

    public static void operation(SalesPerson[] salesTeam) {
        SalesPerson targetSales;
        Scanner input = new Scanner(System.in);
        menu();

        while (input.hasNext()) {
            int choice = input.nextInt();
            try {
                switch (choice) {
                    case 1: // 設定銷售金額
                        targetSales = selectedSales(salesTeam);
                        if (targetSales != null) {
                            System.out.print("請輸入銷售金額： ");
                            double grossSales = input.nextDouble();
                            targetSales.setGrossSales(grossSales);
                        }
                        break;
                    case 2: // 設定獎金比例
                        targetSales = selectedSales(salesTeam);
                        if (targetSales != null) {
                            System.out.print("請輸入獎金比例(0-1)： ");
                            double commissionRate = input.nextDouble();
                            targetSales.setCommissionRate(commissionRate);

                        }
                        break;
                    case 3: // 薪資查詢
                        targetSales = selectedSales(salesTeam);
                        if (targetSales != null) {
                            // 格式化並顯示薪資
                            System.out.printf("業務員薪資: %.2f%n", targetSales.salary());
                        }
                        break;
                    default:
                        System.out.println("無效的選項，請重新選擇！");
                        break;
                }
            }
            catch (IllegalArgumentException ex) {
               // System.out.println("錯誤輸入，請重新選擇！");
                menu();
                continue;
            }
            menu();
        }
        for (SalesPerson s : salesTeam)
            System.out.print(s.toString());
    }

    public static SalesPerson selectedSales(SalesPerson[] salesTeam) {
        Scanner input = new Scanner(System.in);
        System.out.print("請輸入編號： ");
        String salesID = input.next();

        //?????????????????????????????
        //從salesTeam陣列中，搜尋與輸入salesID
        //相同的sales物件，並回傳該物件
        //?????????????????????????????
        // 搜尋業務員編號
        for (SalesPerson s : salesTeam) {
            if (s.getId().equals(salesID)) {
                return s; // 找到對應業務員，並返回該物件
            }
        }

        System.out.println("編號輸入錯誤");
        return null;
    }

    public static void menu() {
        System.out.println("\n\nROC股份有限公司：");
        System.out.print("1.設定銷售金額\n2.設定獎金比例\n3.薪資查詢\n請輸入： ");
    }
}
