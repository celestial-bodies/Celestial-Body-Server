```sql
create table operator
(
  operator_id CHAR(16) FOR BIT DATA not null,
  auth        bigint,
  created     timestamp             not null,
  profile     varchar(1024)         not null,
  rating      bigint,
  primary key (operator_id)
);
create table star
(
  star_id      bigint       not null,
  absmag       double       not null,
  base         varchar(255),
  bayer        varchar(255),
  bf           varchar(255),
  ci           double,
  comp         double       not null,
  comp_primary double       not null,
  con          varchar(255),
  star_dec     double,
  decrad       double       not null,
  dist         double       not null,
  flam         varchar(255),
  gl           varchar(255),
  hd_id        bigint       not null,
  hip_id       bigint       not null,
  hr_id        varchar(255) not null,
  lum          double       not null,
  mag          double       not null,
  pmdec        double       not null,
  pmdecrad     double       not null,
  pmra         double       not null,
  pmrarad      double       not null,
  proper       varchar(255),
  ra           double       not null,
  rarad        double       not null,
  rv           double,
  spect        varchar(255),
  var          varchar(255),
  var_max      double,
  var_min      double,
  vx           double,
  vy           double,
  vz           double,
  x            double       not null,
  y            double       not null,
  z            double       not null,
  primary key (star_id)
);
create table stellar
(
  quote_id    CHAR(16) FOR BIT DATA not null,
  clicks      bigint,
  created     timestamp             not null,
  location    varchar(255),
  object_name varchar(4096)         not null,
  operator_id CHAR(16) FOR BIT DATA not null,
  primary key (quote_id)
);
alter table operator
  add constraint UK_3pd50lv5rpw3jbfnbg6dbiehv unique (profile);
alter table stellar
  add constraint FK9tjxlpr6qw0qpqbkugah36qqq foreign key (operator_id) references operator;
create table operator
(
  operator_id CHAR(16) FOR BIT DATA not null,
  auth        bigint,
  created     timestamp             not null,
  profile     varchar(1024)         not null,
  rating      bigint,
  primary key (operator_id)
)
create table operator_stars
(
  operator_operator_id CHAR(16) FOR BIT DATA not null,
  stars_star_id        bigint                not null
)
create table star
(
  star_id      bigint       not null,
  absmag       double       not null,
  base         varchar(255),
  bayer        varchar(255),
  bf           varchar(255),
  ci           double,
  comp         double       not null,
  comp_primary double       not null,
  con          varchar(255),
  star_dec     double,
  decrad       double       not null,
  dist         double       not null,
  flam         varchar(255),
  gl           varchar(255),
  hd_id        bigint       not null,
  hip_id       bigint       not null,
  hr_id        varchar(255) not null,
  lum          double       not null,
  mag          double       not null,
  pmdec        double       not null,
  pmdecrad     double       not null,
  pmra         double       not null,
  pmrarad      double       not null,
  proper       varchar(255),
  ra           double       not null,
  rarad        double       not null,
  rv           double,
  spect        varchar(255),
  var          varchar(255),
  var_max      double,
  var_min      double,
  vx           double,
  vy           double,
  vz           double,
  x            double       not null,
  y            double       not null,
  z            double       not null,
  primary key (star_id)
)
alter table operator
  add constraint UK_3pd50lv5rpw3jbfnbg6dbiehv unique (profile)
alter table operator_stars
  add constraint FK6lh1nbr7ci31jyjr8vuwi9842 foreign key (stars_star_id) references star
alter table operator_stars
  add constraint FKlig24h9pvn9s31yyuu0f0flno foreign key (operator_operator_id) references operator
```