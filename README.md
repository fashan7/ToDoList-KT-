# ToDoList-KT
This is a basic ToDo List 

This application retrieved all the predefined JSON key values which are TODO's via Retrofit Library. 
This application has predefined Users in the Main Interface.

<img width="353" alt="Screenshot 2022-04-21 at 00 14 13" src="https://user-images.githubusercontent.com/67037844/164333807-69796684-3144-49ac-a7cf-7ba4bb366e41.png">
Main Interface

If any User is selected there are several ToDo's for each n every user. User can add more ToDo's to their List. 
It can be marked as checked or Not. But this is within the app. Once the Application is closed and Opened ToDo's which user added as New will be reset.
There is no Database used (We still can use SQLlite or Firebase to Store ToDo's). For Now its a basic application

<img width="370" alt="Screenshot 2022-04-21 at 00 17 39" src="https://user-images.githubusercontent.com/67037844/164334183-177e5d4d-9442-49e0-a2b0-79bbdf9c50a3.png">
Second Interface

Username isnt hardcoded. It was achieved dynamically with the help of ```intent```

<img width="382" alt="Screenshot 2022-04-21 at 00 18 46" src="https://user-images.githubusercontent.com/67037844/164334274-483f554f-1c22-4848-a93b-b28f93ebcfeb.png">
Third Interface

User can add any ToDo's

Let dive into Coding 😉

To achieve the temperory storing List. The application uses Mutable list as Global variable which can be accessed in any activity

```kotlin:
import android.app.Application
class storeList: Application() {
    companion object {
        val store : MutableList<ToDoObject> = arrayListOf()
    }
}
```

Basically, the application renders all the predefined ToDo's from the server using this url http://jsonplaceholder.typicode.com/todos
Then it is being fetched using retrofit library and added to the ```list```

Once the user clicked their profile, it will be filtered and display their ToDo's using the Kotlin Filteration (Thanks to Kotlin)

```kotlin:
var store_ = store.filterIndexed { index, toDoObject -> toDoObject.userId == id }
```

