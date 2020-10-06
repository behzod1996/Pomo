package com.hfad.pomo.model.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
/*
-안드로이드 아키텍처 컴포넌트에 속하는 Room 라이브러리는 안드로이드 앱에서 SQLite 데이터베이스를
 쉽고 편리하게 사용할 수 있도록 하는 기능입니다.
-@Entity: 데이터베이스 내의 릴레이션 즉 테이블을 뜻하며 Database 에 저장할 데이터 형식을 정의합니다.
-@PrimaryKey: 기본 키를 자동으로 생성합니다.
-@ColumnInfo: 열의 이름을 추가합니다.
-ForeignKey: 이것은 두 개의 테이블을 연결하는 데 사용됩니다. 그래서 부모로부터 업데이트가 나올 때마다 아이들도 업데이트됩니다.
*/
@Entity(tableName = "projects")
data class ProjectEntity(
    @PrimaryKey(autoGenerate = true) val idProject: Long,
    val projectName: String
)