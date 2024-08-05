// A complete basic back-end project of a bank account including 3 stages:
//Stage 1:Build the visual user interface (UI) and set up accounts
//Stag2 2:Define bank account operations
//Stage 3:Manage the bank account


fun main() {
    println("Welcome to your banking system.\n")
    println("What type of account would you like to create?\n")
    println("1. Debit account")
    println("2. Credit account")
    println("3. Checking account")

    var accountType=""
    var userInput= 0
    while(accountType==""){
        println("Choose an option 1,2 or 3")
        var userChoice=(0..5).random()

        println("The selected option is... ${userChoice}")
        when(userChoice){
            1 -> accountType = "debit"
            2 -> accountType = "credit"
            3 -> accountType = "checking"
            else -> continue

        }
        println("You have created a ${accountType} account")

    }

    var accountBalance =(0..1000).random()
    println("The current balance is ${accountBalance}")

    val money =(0..1000).random()
    println("The amount you transferred is ${money}.")

    var output = 0


    fun withdraw(amount:Int): Int{
        accountBalance-= amount
        println("The money withdrawn is ${amount}")
        println("The account balance is ${accountBalance}")
        return amount;
    }

    output = withdraw(money)
    println("The amount you withdrew is ${output} dollars.")


    fun debitWithdraw(amount: Int) :Int {
        if (accountBalance==0){
            println("Can't withdraw, no money on this account!")
            return accountBalance
        }
        else if(accountBalance < amount){
            println("Not enough money on this account! The checking balance is ${accountBalance} dollars.")
            return 0
        }
        else {
            return withdraw(amount)
        }
    }

     output = debitWithdraw(money)
    println("The amount you withdrew is ${output} dollars.")

    fun deposit(amount:Int):Int{
        accountBalance += amount
        println("The account balacnce is ${accountBalance}")
        println("The amount deposited is ${amount}")
        return amount

    }

    output =deposit(money)
    println("The amount you deposited is ${output} dollars.")

    fun creditDeposit(amount: Int): Int{
        if (accountBalance==0){
            println("you don't need to deposit anything in order to pay off the account since it has aready been paid off.")
            return accountBalance
        }
        else if (accountBalance+amount>0){
            println("Deposit failed, you tried to pay off an amount greater than the credit balance. The checking balance is ${accountBalance} dollars.")
        return 0
        }
        else if (amount == -(accountBalance)){
            println("You have paid off this acocunt!")
            return amount
        }
        else{
            return deposit(amount)
        }
        output = creditDeposit(money)
        println("The amount you deposited is ${output} dollars.")
    }


    fun transfer(mode :String){
        val transferAmount: Int
        when(mode){
            "withdraw" -> if (accountType=="debit"){
                 transferAmount= debitWithdraw(money)
                println("The amount you withdrew is ${transferAmount} dollars. ")
            }
            else {
                transferAmount= withdraw(money)
                println("The amount you withdrew is ${transferAmount} dollars. ")
            }

            "deposit" -> if(accountType=="credit"){
                transferAmount= creditDeposit(money)

                println("The amount you deposited is ${transferAmount} dollars. ")
            }
            else{
                transferAmount=deposit(money)
                println("The amount you deposited is ${transferAmount} dollars. ")
            }

            else -> return
        }}

    var isSystemOpen =true
    var option =0
while(isSystemOpen) {
    println(
        "What would you like to do?\n" +
                "\n" +
                "1. Check bank account balance\n" +
                "\n" +
                "2. Withdraw money\n" +
                "\n" +
                "3. Deposit money\n" +
                "\n" +
                "4. Close the app\n" +
                "\n" +
                "Which option do you choose? (1, 2, 3 or 4)"
    )

    option = (1..5).random()
    println("The chosen option is ${option}")
     when(option){
         1 -> println("The current balance is ${accountBalance}")
         2 -> transfer("withdraw")
         3 -> transfer("deposit")
         else -> continue
     }


}
    }

