from Books import Books


class Library:
    def __init__(self):
        self.availableBooks = []
        self.users = []

    def showActiveUsers(self):
        if len(self.users) == 0:
            print("There are no registered books")
        else:
            print("These users own at least one rented book.")
            for user in self.users:
                if user.getRentCounter() > 0:
                    print("|User Name: |" + user.getName() 
                        + "| User Last Name: |" + user.getLastName() 
                        + "| User Age: |" + user.getAge() 
                        + "| User ID: |" + user.userID())

    def activeBooks(self):
        if len(self.availableBooks) == 0:
            print("There are no registered books")
        else:
            for book in self.availableBooks:
                if book.getRentCounter() > 0:
                    print("| TITLE: |" + book.getTitle() + "| NUMBER OF RENTS: | " + book.getRentCounter())
                    if not book.isRented():
                        print(" -Without Owner- ")
                    else:
                        print(" | OWNER: | " + book.getOwner().getName())

    def inactiveBooks(self):
        if len(self.availableBooks) == 0:
            print("There are no registered books")
        else:
            print("These books have not been rented")
            for book in self.availableBooks:
                if book.getRentCounter() == 0:
                    print("| TITLE: |" + book.getTitle() + "| RENT NUMBER: | " + book.getRentCounter())

    def addUser(self, user):
        self.users.append(user)

    def showAllUsers(self):
        for user in self.users:
            print("-------------------------------")
            print("|User Name: |" + user.getName() 
                    + "| User Last Name: |" + user.getLastName() 
                    + "| User Age: |" + user.getAge() 
                    + "| User ID: |" + user.userID())
            print("-------------------------------")
            if len(user.getRentedBooks()) == 0:
                print("This user has not rented any books")
            else:
                print("_____________Rented Books_____________")
                for book in user.getRentedBooks():
                    print("| TITULO: |", book.getTitle())

    def rentBook(self):
        if len(self.users) == 0 or len(self.availableBooks) == 0:
            print("No users or books to rent")
        else:
            i = self.getBookIndex()
            if self.validBookIndex(i):
                if not self.availableBooks[i].isRented():
                    j = self.getUserIndex()
                    if self.validUserIndex(j):
                        self.availableBooks[i].rentBook(self.users[j])
                        self.users[j].rentBook(self.availableBooks[i])
                    else:
                        print("User not found")
                else:
                    print("Already rented by: " + self.availableBooks[i].getOwner().getName())
            else:
                print("Book not found")

    def addBook(self):
        print("Enter the title of the book to add: ")
        title = input()
        book = Books(title)
        self.availableBooks.append(book)
        print("Book added succesfully.")

    def returnBook(self):
        if len(self.availableBooks) == 0:
            print("There are no registered books")
        else:
            i = self.getUserIndex()
            if self.validUserIndex(i):
                if len(self.users[i].getRentedBooks()) != 0:
                    n = self.getBookIndex(i)
                    if self.validBookIndex(n):
                        self.users[i].returnBook(self.availableBooks[n])
                        self.availableBooks[n].returnBook()
                        print("The book has been returned to the bookstore")
                    else:
                        print("The book was not found")
                else:
                    print("This user has not rented anything")
            else:
                print("User not found")

    def showUserNames(self):
        print("These are the available IDs")
        print("----------------------------------")
        for user in self.users:
            print(" | NAME: |" + user.getName() + " | ID: |" + user.userID())

    def getUserIndex(self):
        verification = -1
        self.showUserNames()
        print("Enter the user ID: ")
        ID = input()
        for i in range(len(self.users)):
            if ID == self.users[i].userID():
                verification = i
                break
        return verification

    def validUserIndex(self, valid):
        if valid == -1:
            return False
        else:
            return True

    def showBookTitles(self):
        print("These are the available IDs")
        print("----------------------------------")
        for book in self.availableBooks:
            print(" | TITLE: | " + book.getTitle() + " | Book ID: " + book.getID())

    def showBookTitles(self, i):
        print("These are the IDs available to the user: %s", self.users[i].getName())
        print("----------------------------------")
        for book in self.users[i].getRentedBooks():
            print(" | TITLE: | " + book.getTitle() + " | Book ID: " + book.getID())

    def getBookIndex(self):
        verification = -1
        self.showBookTitles()
        print("Enter the book ID")
        ID = input()
        for i in range(len(self.availableBooks)):
            if ID == self.availableBooks[i].getID():
                verification = i
                break
        return verification

    def getBookIndex(self, i):
        verification = -1
        self.showBookTitles(i)
        print("Enter the book ID")
        ID = input()
        for j in range(len(self.availableBooks)):
            if ID == self.users[i].getRentedBooks()[j].getID():
                verification = j
                break
        return verification

    def validBookIndex(self, valid):
        if valid == -1:
            return False
        else:
            return True

    def showUserData(self):
        if len(self.users) == 0:
            print("")
        else:
            i = self.getUserIndex()
            if self.validUserIndex(i):
                print("0============= USER INFORMATION =============0")
                print("|User Name: |" + self.users[i].getName() 
                    + "| User Last Name: |" + self.users[i].getLastName() 
                    + "| User Age: |" + self.users[i].getAge() 
                    + "| User ID: |" + self.users[i].userID())
                if len(self.users[i].getRentedBooks()) == 0:
                    print("This user has not rented any books")
                else:
                    print("_____________Rented Books_____________ ")
                    for book in self.users[i].getRentedBooks():
                        print(" | TITLE: " + book.getTitle())
                        print()
                print()
            else:
                print("User not found")

    def showAvailableBooks(self):
        if len(self.availableBooks) == 0:
            print("No hay libros registrados")
        else:
            print(" ------------AVAILABLE BOOKS------------")
            for book in self.availableBooks:
                print("| TITLE: |" + book.getTitle() + "| NUMBER OF RENTS: | " +  book.getRentCounter())
                if not book.isRented():
                    print(" | Without Owner | ")
                else:
                    print(" | OWNER: | " + book.getOwner().getName())


