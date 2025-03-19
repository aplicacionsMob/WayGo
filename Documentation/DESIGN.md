# Model de Dades

Aquest document descriurà el model de dades que hem fet servir en la nostra aplicació, incloent-hi les principals entitats i les relacions que tinguin entre elles.


## Diagrama del Model de Dades

classDiagram
    class User {
        +String id
        +String name
        +String email
        +String phoneNumber
        +String profilePictureUrl
        +String bio
        +Int followers
        +Int following
        +Int uploadedRoutes
        +Int totalLikes
        +void register()
        +void login(email, password)
        +void logout()
        +void uploadPhoto(url, description)
    }

class Authentication {
        +String email
        +String password
        +void login(email, password)
        +void logout()
        +void resetPassword(email)
    }

class Preferences {
        +String id
        +Boolean notificationsEnabled
        +String preferredLanguage
        +String theme
        +void updatePreferences()
        +String getPreferences()
    }

class Trip {
        +String id
        +String destination
        +String startDate
        +String endDate
        +Double budget
        +void addItineraryItem(item: ItineraryItem)
        +void removeItineraryItem(itemId: String)
        +void updateTripDetails(newDestination: String, newStartDate: String, newEndDate: String, newBudget: Double)
    }

class ItineraryItem {
        +String id
        +String description
        +String date
        +String location
        +void updateItemDetails(newDescription: String, newDate: String, newLocation: String)
    }

class Photo {
        +String id
        +String url
        +String description
        +void uploadPhoto(newUrl: String, newDescription: String)
    }

class AIRecommendations {
        +String recommendationId
        +String tripId
        +String suggestedActivity
        +Double rating
        +void generateRecommendations()
        +void rateRecommendation(Double rating)
    }

class Map {
        +String location
        +void showLocation()
        +void getNearbyPlaces()
    }

User "1" -- "1" Preferences : has  
User "1" ..> Authentication : uses  
User "1" -- "*" Trip : owns  
User "1" -- "*" Photo : uploads  
User "1" -- "*" AIRecommendations : views  

Trip "1" -- "*" ItineraryItem : contains  
Trip "1" -- "*" Photo : stores  
Trip "1" -- "*" AIRecommendations : gets  
Map ..> Trip : shows location of


---


   A continuació hi ha adjuntada una imatge amb el diagrama de les data class desenvolupades al editor Mermaid:

   

![Untitled diagram-2025-03-18-203947](https://github.com/user-attachments/assets/ca325ae3-7748-4a5a-bfd3-317a8670c33b)

   
