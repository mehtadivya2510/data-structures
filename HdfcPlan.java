public class HdfcPlan {
    public static void main(String[] args) {
        double amount=100000;
        double interest=0.165;
        double sum=0;
        for (int i=0;i<12;i++){
            sum += amount;
            sum += sum*interest;
        }
        System.out.println(sum);
    }
}
