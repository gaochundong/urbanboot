# Urban Boot

An archetype project of spring boot.

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