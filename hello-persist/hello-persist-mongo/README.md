## Auth Config
#### How to create user
```
use hellomongo;
db.createUser({
    user: "hellomongou", 
    pwd: "hellomongop", 
    roles: [{role: "readWrite", db: "hellomongo"}]
});
```

#### How to modify config
Assuming that mongodb is installed via `brew`. The config file is located
at `/usr/local/etc/mongod.conf`. Append to the config file with:
`security.authorization: enabled`

#### How to start
`mongod --config /usr/local/etc/mongod.conf`

#### How to connect via `mongo`
`mongo -u hellomongou -p hellomongop hellomongo`

#### Note 
If there is already a collecton named 'user', drop it by `db.user.drop()`; Or
the unique index will not work.

