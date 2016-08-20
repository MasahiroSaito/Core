## ダウンロード

| Core Version | Spigot Version |
| :----------: | :------------: |
| [2.0](https://github.com/MasahiroSaito/Core/raw/master/mvn-repo/com/Nepian/Spigot/Core/2.0/Core-2.0.jar) | 1.10.2 |

## プラグイン開発用

Maven の pom.xml に以下をそれぞれ追加することで、

このプラグインをベースとしたプラグイン開発を行うことができます。

**repository**

```xml
<repository>
  <id>core-repo</id>
  <url>https://github.com/MasahiroSaito/Core/raw/master/mvn-repo</url>
</repository>
```

**dependency**

```xml
<dependency>
  <groupId>com.Nepian.Spigot</groupId>
  <artifactId>Core</artifactId>
  <version>2.0</version>
</dependency>
```