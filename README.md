# Flow-Task

안녕하세요, 이태균입니다.  
마드라스 체크 기업 과제로 진행한 **파일 확장자 차단** 프로젝트의 리드미 파일입니다.

## 프로젝트 주소

- **[GitHub Repository](https://github.com/taegyun1995/Flow-Task)**
- **[배포 주소](http://3.35.212.118:8080/flow)**

## 요건

### 고정 확장자
- 고정 확장자는 자주 차단되는 확장자 리스트입니다. 기본적으로 체크 해제 상태입니다.
- 고정 확장자를 체크/해제하면 데이터베이스에 상태가 저장됩니다. (새로고침 시 상태가 유지됩니다.)
- 커스텀 확장자 리스트에는 표시되지 않습니다.

### 커스텀 확장자
- 확장자의 최대 입력 길이는 20자입니다.
- 추가 버튼을 클릭하면 데이터베이스에 저장되며, 아래 영역에 표시됩니다.
- 최대 200개의 커스텀 확장자를 추가할 수 있습니다.
- 확장자 옆 X 버튼을 클릭하면 데이터베이스에서 삭제됩니다.

### 추가 요건
- 고정 확장자는 CHECK/UNCHECK로 확장자에 상태를 부여합니다.
- 보안과 관련하여 정보의 무결성이 중요하다고 판단하여 새로고침 시 항상 고정 확장자 리스트를 조회하도록 구현했습니다.
- 커스텀 확장자에는 고정 확장자가 추가되지 않도록 했습니다.
- 커스텀 확장자는 유니크하므로 중복 추가는 불가능합니다.

## 데이터베이스 스키마
### 고정 확장자

```sql
CREATE TABLE fixed_extensions (
    id INT AUTO_INCREMENT PRIMARY KEY,
    extension_name VARCHAR(255) NOT NULL UNIQUE,
    status VARCHAR(255) NOT NULL DEFAULT 'UNCHECK'
);
```

### 커스텀 확장자
```sql
CREATE TABLE custom_extensions (
    id INT AUTO_INCREMENT PRIMARY KEY,
    extension_name VARCHAR(20) NOT NULL UNIQUE
);
```

### 고정 확장자 데이터 삽입
```sql
INSERT INTO fixed_extensions (extension_name)
VALUES  
    ('bat'),  
    ('cmd'),  
    ('com'),  
    ('cpl'),  
    ('exe'),  
    ('scr'),  
    ('js');
```

