public interface OnlineAccount {
    int basePrice=1,regularMoviePrice=10,exclusiveMoviePrice=100;
}

class Account implements OnlineAccount,Comparable<Account>{
    int noOfRegularMovies;
    int noOfExclusiveMovies;
    String ownerName;

    //parameterized constructor
    Account(int noOfRegularMovies, int noOfExclusiveMovies, String ownerName){
        this.noOfRegularMovies=noOfRegularMovies;
        this.noOfExclusiveMovies=noOfExclusiveMovies;
        this.ownerName=ownerName;
    }
    
    int monthlyCost(){
        return basePrice + noOfRegularMovies*regularMoviePrice + noOfExclusiveMovies*exclusiveMoviePrice;
    }

    @Override
    public int compareTo(Account o) {
        return this.monthlyCost()-o.monthlyCost();
    }

    @Override
    public String toString() {
        return "Owner is "+ this.ownerName +" and monthly cost is "+ this.monthlyCost() +" USD.";
    }

    public static void main(String[] args) {
        Account a=new Account(1,2,"Divya");
        System.out.println(a);
    }

}

