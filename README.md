# Azura Java

[![](https://jitpack.io/v/azura-client/Azura4J.svg)](https://jitpack.io/#DxsSucuk/KingGenJava)

###### API Wrapper developed for Azura by Presti (Azura Dev)

## Maven
```xml
<repositories>
  <repository>
    <id>jitpack.io</id>
    <url>https://jitpack.io</url>
  </repository>
</repositories>

<dependencies>
  <dependency>
    <groupId>best.azura</groupId>
    <artifactId>Azura4J</artifactId>
    <version>Tag</version>
  </dependency>
</dependencies>
```

## How to use?

You have to create a new Instance of the Azura Wrapper. Example:

```java
Azura azura = new Azura("Your API-Key");
```

After creating a new Instance of the wrapper, you simply call the request methode with an Endpoint. Example:

```java
package your.very.cool.project.or.what.ever.lol;

import java.lang.Exception;

import best.azura.azura4j.entities.AzuraUserStats;
import best.azura.azura4j.entities.AzuraApplicationStats;
import best.azura.azura4j.entities.AzuraUser;
import best.azura.azura4j.Azura;

public class Tutorial {

    Azura azura = new Azura("Your API-Key");

    public void fetchUserStats() throws Exception {
        AzuraUserStats azuraUserStats = azura.fetchUserStats();
    }

    public void fetchApplicationStats() throws Exception {
        AzuraApplicationStats azuraApplicationStats = azura.fetchApplicationStats();
    }

    public void lookupUser(String username) throws Exception {
        AzuraUser azuraUser = azura.lookupUser(username);
    }

    public void fetchUserStatsASync() throws Exception {
        azura.fetchUserStatsASync(azuraUserStats -> /* Do the funny*/, Throwable::printStackTrace);
    }

    public void fetchApplicationStatsASync() throws Exception {
        azura.fetchApplicationStatsASync(azuraApplicationStats -> /* Do the funny*/, Throwable::printStackTrace);
    }

    public void lookupUserASync(String username) throws Exception {
        azura.lookupUserASync(username, azuraUser -> /* Do the funny*/, Throwable::printStackTrace);
    }
}
```

Non-ASync methods will give you an Entity-class if it was successful, otherwise it will throw an Exception,
that you have to handle yourself. But ASync methods will not return anything and will throw an Exception if the success Callback is null.

## If you have Issues implementing it.

You can contact me. Discord: El Rosé#6603
