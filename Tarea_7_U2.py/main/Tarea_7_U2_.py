from main.Bank import Bank
from main.Employee import Employee


bank = Bank()

def main():
    flag = True
    while flag:
        print("===============================================================")
        print("1. Add Account of Employee")
        print("2. Add Money")
        print("3. Withdrawals")
        print("4. Show Account of User")
        print("5. Show all Employees")
        print("6. Show all Accounts")
        print("7. Exit")
        print("Select your option: ")
        print("===============================================================")
        option = input()
        if option == '1':
            employee.add_employee_account()
        elif option == '2':
            employee.add_money()
        elif option == '3':
            employee.withdraw_money()
        elif option == '4':
            employee.show_account()
        elif option == '5':
            employee.show_all_employees()
        elif option == '6':
            bank.show_all_bank_accounts()
        elif option == '7':
            print("Finishing all Tasks.")
            flag = False
        else:
            print("Not an option. Enter a number from 1 to 7.")
if __name__ == "__main__":
    employee = Employee("", "", 132, ' ')
    main()
