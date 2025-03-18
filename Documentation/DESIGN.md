# 📌 Model de Dades

Aquest document descriurà el model de dades que hem fet servir en la nostra aplicació, incloent-hi les principals entitats i les relacions que tinguin entre elles.


## 🛠️ **Diagrama del Model de Dades**

classDiagram
    class User {
        +String id
        +String name
        +String email
        +String? phoneNumber
        +String? profilePictureUrl
        +String? bio
        +Int followers
        +Int following
        +Int uploadedRoutes
        +Int totalLikes
    }

   class Preferences {
        +String id
        +Boolean notificationsEnabled
        +String preferredLanguage
        +String theme
    }

   class Trip {
        +String id
        +String destination
        +Date startDate
        +Date endDate
        +Double budget
    }

   class ItineraryItem {
        +String id
        +String description
        +Date date
        +String location
    }

   class Photo {
        +String id
        +String url
        +String? description
    }

   User "1" -- "1" Preferences : has
   User "1" -- "*" Trip : owns
   User "1" -- "*" Photo : uploads

   Trip "1" -- "*" ItineraryItem : contains
   Trip "1" -- "*" Photo : stores


   
