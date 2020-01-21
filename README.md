# Urban Boot

An archetype project of spring boot.

- 这是一个关于 Spring Boot 的脚手架项目，用于快速基于原型搭建可用项目，布局纯依据个人喜好。

## autoconf setup

- Create a folder '~/autoconf/dev', then the maven plugin will put an antx.properties file within the folder.

## maven build

- Create a new Maven Debug Configurations with the Command line 'clean package exec:java' and profile 'dev'.

## maven package

- Just 'mvn package' or 'mvn package -Pprod'.

## profile list

- dev
- test
- stage
- pre
- beta
- prod

## ping

- curl http://localhost:7200
- curl http://localhost:7200/ping
- curl http://localhost:7200/health