Horntell SDK for Java
=====================

This SDK allows you to easily integrate Horntell in your Java applications.

## Requirements

Java 1.6 and later.

## Installation

### Maven Users

Add this dependency to your project's POM.

```xml
<dependency>
  <groupId>com.horntell</groupId>
  <artifactId>java-sdk</artifactId>
  <version>0.1.0</version>
</dependency>
```

### Gradle users

Add this dependency to your project's build file:

```groovy
compile "com.horntell:java-sdk:0.1.0"
```

### Others

You'll need to manually install the following JARs:

* The Horntell JAR from https://github.com/horntell/java-sdk/releases/latest

## Getting Started

You need to `init`ialize the SDK with the app's key and secret, which you can find in your account at [http://app.horntell.com](http://app.horntell.com). Sample usage looks like this.

```java
com.horntell.App.init('YOUR_APP_KEY', 'YOUR_APP_SECRET');

Map<String,Object> newProfileMap = new HashMap<>();
newProfileMap.put("uid", "1337");
newProfileMap.put("first_name", "John");
newProfileMap.put("last_name", "Doe");
newProfileMap.put("signedup_at", 1383350400);

com.horntell.Profile.create(newProfileMap);
```

## Documentation

Please see [http://docs.horntell.com/api](http://docs.horntell.com/api/?java) for up-to-date documentation.

### Authentication

Authentication is easy and one liner, just replace hornokpleasekey & hornokpleasesecret from the code snippet.

```java
	App.init(hornokpleasekey,hornokpleasesecret);
```
Set your base path and version.
### Configure
```java
        App.setBase("http://api.horntell.com");
        App.setVersion("v1");
```

### Profile
> Create a new Profile
```java
        Map<String,Object> requestMap = new HashMap<>();
        requestMap.put("app_id","adfadf165ads1f6a1d6f5asdf621");
        requestMap.put("email","john.doe@example.com");
        requestMap.put("first_name","John");
        requestMap.put("last_name","Doe");
        requestMap.put("signedup_at",12346548979);
        requestMap.put("gender","male");
        requestMap.put("uid", "my_user_unique_id");
        HorntellResponse response = Profile.create(requestMap);
```
HorntellResponse is a wrapper around HttpResponse. Some of the methods defined are:-
* getResponseMap() : Converts the response Json to HashMap and return it
* getStatusCode() : To get status code of response
* getBody() : Get response body in the form of String

>> Expected JSON
```json
{
    "data": {
        "uid": "720974375",
        "first_name": "John",
        "last_name": "Doe",
        "email": "john.doe@example.com",
        "signedup_at": 12346548979,
        "avatar_url": null,
        "gender": "Male",
        "position": null,
        "company": null,
        "industry": null,
        "location": null,
        "birthday": null,
        "headline": null,
        "last_seen_at": 1404991674,
        "custom_attributes": {
            "type": "earlybird"
        }
    }
}
```
> Update an existing profile

```java
        Map<String,Object> requestMap = new HashMap<>();
        requestMap.put("first_name","Jhonny");
        HorntellResponse response = Profile.update(savedUid, requestMap);
```

> Find a profile
```java
 HorntellResponse response = Profile.find(savedUid);
 ```
 > Delete a profile
 ```java
 HorntellResponse response = Profile.delete(savedUid);
 ```
 
 # Horns
 Horns are the notifications in the Horntell’s terminology. A horn is the primary way of keeping your users engaged in the app. Horns can be sent to a particular profile or multiple profiles. An horn can be of one of four formats:

**Simple**: Horns of this format do not have anything special about them. They are useful for notifying users about some activity in their account. They cannot interact with these horns. Of course, you can add the links through custom HTML, but we do not take responsibility of their interaction.

**Ask**: Horns of this format provides you ability to add upto 3 buttons for your users to interact with. These can be used to have a single question surveys.

**Link**: Horns of this format provides you the ability to provide a clickable notification, which will take the user to a diffferent page. This format works best for notifications.

**Talk**: Horns of this type comes with an input box under them. Users can type in anything and talk to you directly through the horn. These are very useful to build trust among users or to collect some small pieces of information like their email addresses.

> Create a new horn

```java
Map<String,Object> requestMap = new HashMap<>();
requestMap.put("format","link");
requestMap.put("type","info");
requestMap.put("bubble",true);
requestMap.put("text","Welcome campaign was fired.");
requestMap.put("html","<strong>Welcome</strong> campaign was fired.");
requestMap.put("link","http://app.example.com/campaigns/welcome");
requestMap.put("new_window",true);
HorntellResponse response = Horn.toProfile("500132", requestMap);
```
> Expected JSON

```json
{
    "id": "552238c4bffebca40c8b4567",
    "profile_uid": "720974375",
    "trigger": {
        "type": "campaign",
        "id": "5522354fbffebcf30b8b4567",
        "meta": {
            "friend_name": "Alley Doe"
        }
    },
    "format": "talk",
    "bubble": true,
    "type": "success",
    "text": "Enter your email to receive updates from us!",
    "html": "<p>We've got a killer roadmap ahead. Want to stay updated?</p><p>Your email address please?</p>",
    "delivered_at": 1428306117,
    "seen_at": 1428306116,
    "read_at": 1428306294,
    "responded_at": 1428306294,
    "response": "john@example.com",
    "created_at": 1428306116
}
```

# Campaigns

There’s a problem when you hard-code the content of horns in your codebase, commit it and push it to production. The problem is that, if you want to change the content of horns, you’ll have to repeat the whole cycle of code - commit - ship to get it done. This sucks. And campaigns solve this problem.

Campaigns allow you to keep the horns stored as templates in your account and when you need to send a horn, simply use API endpoint to run a particular campaign. This has two benefits over hard-coding horn’s data in the codebase:

You can modify horn’s content really quickly from your Horntell dashboard - without touching your codebase ever.
The stats to all the horns under one campaign can be seen together for analysis.

>>>  While using campaigns, horn’s content can be personalized using placeholders (eg. {first_name}), which will be parsed and replaced whenever creating horns for a profile.

> Run Campaign for a Single Profile
```java
Map<String,Object> requestMap = new HashMap<>();
requestMap.put("name","Dave");
HorntellResponse response = Campaign.toProfile("profile_id", "campaign_id", requestMap);
```
> Run Campaign for a Multiple Profiles

```java
Map<String,Object> requestMap = new HashMap<>();
requestMap.put("name","Dave");
String[] profile_ids = {"500132","836408.4419760975"};
HorntellResponse response = Campaign.toProfiles(profile_ids,"56496ba09f17f6ba348b4567", requestMap);
```

For more details visit http://docs.horntell.com/api/
 









