## SIMPLE LIBRARY EXERCISE
It's a library's system applying adapters and ports arquitecture.

## PROJECT STRUCTURE
```
├── 📁 lib
├── 📁 src
│   ├── 📁 modules
│   │   ├── 📁 books
│   │   │   ├── 📁 app
│   │   │   │   └── 📁 services
│   │   │   │       └── ☕ BookService.java
│   │   │   ├── 📁 domain
│   │   │   │   ├── 📁 exceptions
│   │   │   │   │   ├── 📁 models
│   │   │   │   │   │   ├── ☕ BookGenderInvalidException.java
│   │   │   │   │   │   ├── ☕ BookIsbnInvalidException.java
│   │   │   │   │   │   ├── ☕ BookLocalDateInvalidException.java
│   │   │   │   │   │   ├── ☕ BookPagesInvalidException.java
│   │   │   │   │   │   └── ☕ BookStateInvalidException.java
│   │   │   │   │   ├── ☕ BookCouldNotBeCreatedException.java
│   │   │   │   │   ├── ☕ BookInvalidException.java
│   │   │   │   │   └── ☕ BooksNotFoundException.java
│   │   │   │   ├── 📁 models
│   │   │   │   │   ├── 📁 valueObjects
│   │   │   │   │   │   ├── 📁 enums
│   │   │   │   │   │   │   └── ☕ BookGender.java
│   │   │   │   │   │   ├── ☕ BookAuthor.java
│   │   │   │   │   │   ├── ☕ BookAvailability.java
│   │   │   │   │   │   ├── ☕ BookId.java
│   │   │   │   │   │   ├── ☕ BookIsbn.java
│   │   │   │   │   │   ├── ☕ BookPages.java
│   │   │   │   │   │   ├── ☕ BookReleaseDate.java
│   │   │   │   │   │   └── ☕ BookTitle.java
│   │   │   │   │   └── ☕ Book.java
│   │   │   │   ├── 📁 ports
│   │   │   │   │   ├── 📁 inport
│   │   │   │   │   │   └── ☕ IBookServiceInport.java
│   │   │   │   │   └── 📁 outport
│   │   │   │   │       └── ☕ IBookRepositoryOutport.java
│   │   │   │   ├── 📁 services
│   │   │   │   │   └── ☕ BookServiceValidator.java
│   │   │   │   └── 📁 ui
│   │   │   │       └── 📁 console
│   │   │   │           ├── 📁 templates
│   │   │   │           │   └── ☕ BookTemplate.java
│   │   │   │           └── ☕ BookConsole.java
│   │   │   └── 📁 infrastructure
│   │   │       └── 📁 adapters
│   │   │           ├── 📁 inbound
│   │   │           │   └── 📁 controllers
│   │   │           │       └── ☕ BookController.java
│   │   │           └── 📁 outbound
│   │   │               └── 📁 repositories
│   │   │                   └── ☕ BookRepositoryInMemory.java
│   │   ├── 📁 loans
│   │   │   ├── 📁 app
│   │   │   │   └── 📁 services
│   │   │   ├── 📁 domain
│   │   │   │   ├── 📁 exceptions
│   │   │   │   ├── 📁 models
│   │   │   │   ├── 📁 ports
│   │   │   │   │   ├── 📁 inport
│   │   │   │   │   └── 📁 outport
│   │   │   │   └── 📁 services
│   │   │   └── 📁 infrastructure
│   │   │       └── 📁 adapters
│   │   │           ├── 📁 inbound
│   │   │           │   └── 📁 controllers
│   │   │           └── 📁 outbound
│   │   │               └── 📁 repositories
│   │   └── 📁 users
│   │       ├── 📁 app
│   │       │   └── 📁 services
│   │       │       └── ☕ UserService.java
│   │       ├── 📁 domain
│   │       │   ├── 📁 exceptions
│   │       │   │   ├── 📁 models
│   │       │   │   │   ├── ☕ UserAgeInvalidException.java
│   │       │   │   │   ├── ☕ UserGenderInvalidException.java
│   │       │   │   │   ├── ☕ UserIcInvalidException.java
│   │       │   │   │   └── ☕ UserNameInvalidException.java
│   │       │   │   ├── ☕ UserCouldNotBeCreatedException.java
│   │       │   │   ├── ☕ UserInvalidException.java
│   │       │   │   └── ☕ UsersNotFoundException.java
│   │       │   ├── 📁 models
│   │       │   │   ├── 📁 valueObjects
│   │       │   │   │   ├── 📁 enums
│   │       │   │   │   │   └── ☕ UserGender.java
│   │       │   │   │   ├── ☕ UserAge.java
│   │       │   │   │   ├── ☕ UserIc.java
│   │       │   │   │   ├── ☕ UserId.java
│   │       │   │   │   ├── ☕ UserLastname.java
│   │       │   │   │   └── ☕ UserName.java
│   │       │   │   └── ☕ User.java
│   │       │   ├── 📁 ports
│   │       │   │   ├── 📁 inport
│   │       │   │   │   └── ☕ IUserServiceInport.java
│   │       │   │   └── 📁 outport
│   │       │   │       └── ☕ IUserRepositoryOutpor.java
│   │       │   ├── 📁 services
│   │       │   │   └── ☕ UserServiceValidator.java
│   │       │   └── 📁 ui
│   │       │       └── 📁 console
│   │       │           ├── 📁 templates
│   │       │           │   └── ☕ UserTemplate.java
│   │       │           └── ☕ UserConsole.java
│   │       └── 📁 infrastructure
│   │           └── 📁 adapters
│   │               ├── 📁 inbound
│   │               │   └── 📁 controllers
│   │               │       └── ☕ UserController.java
│   │               └── 📁 outbound
│   │                   └── 📁 repositories
│   │                       └── ☕ UserRepositoryInMemory.java
│   ├── 📁 shared
│   │   ├── 📁 exceptions
│   │   │   ├── 📁 validators
│   │   │   │   ├── ☕ GenericNumericValidator.java
│   │   │   │   └── ☕ GenericStringValidator.java
│   │   │   ├── ☕ GenericNumberInvalidException.java
│   │   │   └── ☕ GenericStringBoundaryException.java
│   │   ├── 📁 ui
│   │   │   └── 📁 console
│   │   │       ├── 📁 templates
│   │   │       │   └── ☕ GenericTemplates.java
│   │   │       └── ☕ GenericConsole.java
│   │   └── ☕ App.java
│   └── 📁 tests
│       ├── ☕ ExampleId.java
│       └── ☕ TestApp.java
└── 📝 README.md
```
---
*Generated by FileTree Pro Extension*
