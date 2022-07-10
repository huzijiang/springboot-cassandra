-------------------------------------------------测试------------------------------------------

CREATE KEYSPACE demo WITH replication = {'class':'SimpleStrategy', 'replication_factor' : 1};
use demo;
-- 创建测试表
CREATE TABLE location
(
    vehicle_id text,
    date       text,
    time       timestamp,
    latitude   double,
    longitude  double,
    PRIMARY KEY ((vehicle_id, date), time)
) WITH CLUSTERING ORDER BY (time DESC);

--- 创建类型
use demo;
CREATE TYPE address ( street text, city text, zip_code int, phone text);

--更改表以添加新类型为列，
alter table location
    add address frozen<address>;


-------------------------------------------------龙源项目------------------------------------------
-- cassandra_project_ly 龙源项目
CREATE KEYSPACE jarvis_datastore WITH replication = {'class':'SimpleStrategy', 'replication_factor' : 1};

use jarvis_datastore;

create table jarvis_datastore.device_connection_event
(
    device_id  bigint,
    created_at timestamp,
    reason     text,
    status     text,
    primary key (device_id, created_at)
)
    with clustering order by (created_at desc)
     and caching = {'keys': 'ALL', 'rows_per_partition': 'NONE'}
     and compaction = {'max_threshold': '32', 'min_threshold': '4', 'class': 'org.apache.cassandra.db.compaction.SizeTieredCompactionStrategy'}
     and compression = {'class': 'org.apache.cassandra.io.compress.LZ4Compressor', 'chunk_length_in_kb': '64'}
     ;

create table jarvis_datastore.device_data_point
(
    device_id            bigint,
    identifier           text,
    created_at           timestamp,
    action_parameters    text,
    desired_at           timestamp,
    desired_value        text,
    direction            text,
    level                text,
    metadata             text,
    reported_at          timestamp,
    reported_value       text,
    reported_value_array list<float>,
    result               text,
    primary key ((device_id, identifier), created_at)
)
    with clustering order by (created_at desc)
     and caching = {'keys': 'ALL', 'rows_per_partition': 'NONE'}
     and compaction = {'max_threshold': '32', 'min_threshold': '4', 'class': 'org.apache.cassandra.db.compaction.SizeTieredCompactionStrategy'}
     and compression = {'class': 'org.apache.cassandra.io.compress.LZ4Compressor', 'chunk_length_in_kb': '64'}
     and gc_grace_seconds = 1;

create index idx_data_point_direction
    on jarvis_datastore.device_data_point (direction);


create table jarvis_datastore.device_long_array_temp
(
    device_id            bigint,
    identifier           text,
    data_index           int,
    reported_value_array list<float>,
    primary key ((device_id, identifier), data_index)
)
    with caching = {'keys': 'ALL', 'rows_per_partition': 'NONE'}
     and compaction = {'max_threshold': '32', 'min_threshold': '4', 'class': 'org.apache.cassandra.db.compaction.SizeTieredCompactionStrategy'}
     and compression = {'class': 'org.apache.cassandra.io.compress.LZ4Compressor', 'chunk_length_in_kb': '64'}
     ;

--执行问题：





