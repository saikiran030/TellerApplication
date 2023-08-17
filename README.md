# TellerApplication
TellerApplication
=====================
Create a Teller application
=====================
=======
Personas
=======
-Maker
-Checker
- Authorizer
Integrate with -> Keycloak open source IAM
===================
UI (Angular 8/9) (CRUD)
===================
- Create Customer
- Create Accounts
- One Customer may have more than 1 account

App should be able to do below operations on UI
- Deposits
- Withdrawals

==========
Business rule
==========
If any customer wants to withdraw over $1000, Authorizer has to approve it.
Create dashbaords (for transaction type by date by Customer)

===========
Search Screen :
===========
Input account number, it should display transactions for that account, if input is customer id it should display for all transaction for his accounts
====
APIs
====
1. Input Customer ID; able to retreive account balances(opening balance, closing balances) for all accounts for that customer
2. Input customer ID, Account no. able to retreive account balances (opening balance, closing balances) for that account
3. Input Account Number, retrun the Customer Id, Account Id, Opening balance, closing balance, Interest posted

Integrate with any open sourece any API gateway (APIMAN or TYK or WS02)


unit testing, design 
