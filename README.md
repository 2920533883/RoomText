# RoomText   
## Room数据库基础    
### Room持久性库在 SQLite 的基础上提供了一个抽象层，让用户能够在充分利用 SQLite 的强大功能的同时，获享更强健的数据库访问机制。

![关系图](https://developer.android.google.cn/images/training/data-storage/room_architecture.png?hl=zh-cn)

### Room 包含3个主要组件： 
- 数据库：包含数据库持有者，并作为应用已保留的持久关系型数据的底层连接的主要接入点。  
  - 使用 @Database 注释的类应满足以下条件：
      - 是扩展 RoomDtabase 的抽象类。
      - 在注释中添加与数据库关联的实体列表。
      - 包含具有 **0** 个参数且返回iu使用 @Dao 注释的类。  
      在运行时, 可以通过 **Room.databaseBuilder()** 或 **Room.inMemoryDtabaseBuilder()** 获取 Database 的实例。
- Entity：表示数据库中的表。
- Dao：包含用于访问数据库的方法。
  - @Insert 插入操作 返回值为插入的行数,类型为long。
  - @Update 更新操作 返回值更新的行数，类型为int。
  - @Delete  删除操作，返回值为删除的行数，类型为int。
  - @Query 读写操作，可用SQL语法筛选，返回值为子表。
