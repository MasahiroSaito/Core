## ダウンロード

| Core Version | Spigot Version |
| :----------: | :------------: |
| [2.1](https://github.com/MasahiroSaito/Core/raw/master/mvn-repo/com/Nepian/Spigot/Core/2.1/Core-2.1.jar) | 1.10.2 |

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
  <version>2.1</version>
</dependency>
```

> API Document: [https://masahirosaito.github.io/Core/apidocs/](https://masahirosaito.github.io/Core/apidocs/)
