import sys

from Library import Library


if __name__ == "__main__":
    library = Library()
    flag = True
    while flag:
        print("0=====================================0")
        print("        WELCOME TO THE LIBRARY         ")
        print("1. Add User")
        print("2. Show all Users in System")
        print("3. Show all Books rented by one user")
        print("4. Rent a Book")
        print("5. Add any Book")
        print("6. Return any book")
        print("7. Show all books in Library")
        print("8. Query all active users")
        print("9. View active books")
        print("10. View inactive books")
        print("11. Exit Library")
        print("0==================================0")
        option = int(input())
        if option == 1:
            name = input("Enter user's first name: ")
            lastName = input("Enter user's last name: ")
            age = int(input("Enter age: "))
            user = {'name': name, 'lastName': lastName, 'age': age}
            library.addUser(user)
        elif option == 2:
            library.showAllUsers()
        elif option == 3:
            library.showUserData()
        elif option == 4:
            library.rentBook()
        elif option == 5:
            library.addBook()
        elif option == 6:
            library.returnBook()
        elif option == 7:
            library.showAvailableBooks()
        elif option == 8:
            library.showActiveUsers()
        elif option == 9:
            library.inactiveBooks()
        elif option == 10:
            library.activeBooks()
        elif option == 11:
            print("Closing the Library")
            flag = False
        else:
            print("(!)NOT AN OPTION(!)")


