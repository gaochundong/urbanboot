# Urban Boot

- 这是一个关于 Spring Boot 的脚手架项目，用于快速基于原型搭建可用项目，布局纯依据个人习惯。

## autoconf setup (optional)

- Create a folder '~/autoconf/dev', then the maven plugin will put an antx.properties file within the folder.

## maven build

- Create a new Maven Debug Configurations with the Command line 'clean package exec:java' and profile 'dev'.

## maven package

- Just 'mvn package' or 'mvn package -Pdev'.

## maven install

- mvn clean install -U -Pdev

## maven deploy

- mvn clean install -U deploy -N -Pdev

## profile list

- dev
- test
- stage
- pre
- beta
- prod
