## ダウンロード

| Core Version | Spigot Version |
| :----------: | :------------: |
| [1.0](https://github.com/MasahiroSaito/Core/raw/master/mvn-repo/com/Nepian/Spigot/Core/1.0/Core-1.0.jar) | 1.10.2 |

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
  <version>1.0</version>
</dependency>
```

> API Document: [https://masahirosaito.github.io/Core/apidocs/](https://masahirosaito.github.io/Core/apidocs/)
