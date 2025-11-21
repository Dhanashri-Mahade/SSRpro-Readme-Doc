
# **SSRpro Backend – Intern Onboarding & Setup Guide**

*(For new interns – Local machine setup, project cloning, and backend development rules)*

---

# **Chapter 1 – Required Tools & Local Machine Setup**

Before beginning development on the SSRpro Backend, every intern must prepare their local environment properly. This ensures that the project runs smoothly and reduces configuration issues.

## **1. Code Editor / IDE**

You may use any IDE that supports Java, but the company recommends:

* **IntelliJ IDEA** 
* **VS Code** 
* **Eclipse IDE**

Interns are free to choose any editor as long as they are comfortable.

---

## **2. Install Java 21 (JDK 21)**

SSRpro requires **Java 21**.
After installation, verify using:

```
java -version
```

Expected output example:

```
Java version: 21.0.8, vendor: Oracle Corporation
```

---

## **3. Install Maven**

Apache Maven is required for building and running the Spring Boot application.
Verify installation:

```
mvn --version
```

Expected output example:

```
Apache Maven 3.9.11
Java version: 21.0.8
```

---

## **4. Database Setup**

Install the following:

* **MySQL Server 8.x**
* **MySQL Workbench**

You will import the project database after cloning the repository.

---

## **5. Git Setup (Version Control)**

Install Git on your system and configure your **local project-level** user details.

Before working on the SSRpro Backend, interns must set their Git identity **only inside the project folder**, not globally.

### **Steps:**

1. Go to the project folder:

```
cd path/to/SiliconMount/SSR-Pro
```

2. Set local Git user details:

```
git config user.name "Firstname Lastname"
git config user.email "official-email@siliconmount.com"
```

3. Verify:

```
git config user.name
git config user.email
```

### **Note (Important for Interns):**

* Always set your Git user identity **inside the SSRpro project folder only**.
* Every commit in this repository must use your **official SiliconMount email**.

---

## **6. Spring Boot**

You do **not** need to install Spring Boot separately.
It will automatically run using Maven commands inside the project.

---

### **⚠️ Note (Important – Must Follow):**

* **Do NOT install unnecessary third-party tools unless asked.**
* **Do NOT change Java or Maven versions without approval.**

---

---

# **Chapter 2 – Cloning the Project & Branch Workflow**

This chapter explains how interns must properly clone the project, create branches, and manage version control while working on SSRpro.

## **1. Clone the Repository (Only Main Branch Must Be Used)**

Project GitHub URL:

```
https://github.com/SiliconMount-Tech-Services-Pvt-Ltd/SSR-Pro.git
```

Clone command:

```
git clone -b main https://github.com/SiliconMount-Tech-Services-Pvt-Ltd/SSR-Pro.git
```

### **⚠️ Note (Extremely Important):**

* The default branch on GitHub is **master**,
  **but interns should NEVER clone or work on master.**
* Always use **main** ONLY.

---

## **2. Creating Your Personal Branch**

Every intern must create a new branch right after cloning.

Allowed branch name formats:

* **firstname-dd-mm-yyyy-feature**
* **firstname-dd-mm-yyyy** (if feature name is not required)

Examples:

```
priya-20-11-2025
rushikesh-22-11-2025-masterapi
```

Create branch command:

```
git checkout -b your-branch-name
```

---

## **3. Import the Database**

Inside the project directory, interns will find:

```
src/DataBase/sts_ssrpro.sql
```

Steps:

1. Open MySQL Workbench
2. Create a new database (sts_ssrpro)
3. Import the `sts_ssrpro.sql` file
4. Execute to generate all tables
5. Confirm that tables are created successfully

Without this database, the backend API will not start.

---

## **4. Commit Rules**

Commit only when a complete task or API is finished.

Commit message format:

```
dd-mm-yyyy : firstname : message
```

Example:

```
21-11-2025 : dhanashri : added material testing API
```

---

## **5. Push Rules**

Before pushing code, follow this process:

1. Ask a senior developer to review your work
2. Pull latest updates from main
3. Resolve conflicts
4. Push your code only to your branch

### **⚠️ Note (Strict Rule):**

* Never push code to **main**, **master**, or **any other developer’s branch**.
* All work must remain inside **your personal branch only**.

---

---

# **Chapter 3 – API Development Rules (SSRpro Backend)**

This chapter explains the conventions and rules interns must follow while building new APIs in the project.

---

## **1. Understanding Table Types**

The SSRpro database contains two categories of tables:

### **a) Master Tables**

Example:

```
master_geospecificareas
```

Java class naming:

```
MasterGeoSpecificAreasController
```

### **b) Transaction Tables**

Example:

```
txn_item_mts
```

Java naming:

```
TxnItemMtsController
```

### **⚠️ Note:**

* Always use **Master** prefix for master tables.
* Always use **Txn** prefix for transaction tables.
* Naming must be correct; no shortcuts or custom names allowed.

---

## **2. Required File Set for Every API**

Each API module must contain the following 6 files, and names must strictly follow the same format:

1. **DTO**
   Example: `MasterGeoSpecificAreasDTO`
2. **Entity**
   Example: `MasterGeoSpecificAreasEntity`
3. **Mapper**
   Example: `MasterGeoSpecificAreasMapper`
4. **Repository**
   Example: `MasterGeoSpecificAreasRepository`
5. **Service**
   Example: `MasterGeoSpecificAreasService`
6. **Controller**
   Example: `MasterGeoSpecificAreasController`

For transaction tables, use:

```
TxnItemMtsDTO
TxnItemMtsEntity
TxnItemMtsMapper
TxnItemMtsRepository
TxnItemMtsService
TxnItemMtsController
```

### **⚠️ Note:**

* File names must match exactly.
* Do not rename, abbreviate, or alter casing.
* Follow the standard format for every API.

---

---

# **CHAPTER 4 – Backend File Structure & Coding Standards (TxnItemMts API Example)**

This chapter explains the exact file structure, naming conventions, and implementation style that must be followed when creating any API inside the SSRpro Backend. Every intern must strictly follow these guidelines to maintain consistency across all modules.

---

## **4.1 DTO File**

### **Filename Structure**

```
<EntityName>DTO.java
```

### **Rules**

* A DTO must contain only fields, constructors, getters, setters, and a `toString()` method.
* No business logic is allowed inside DTOs.
* DTO field names must be in camelCase.
* DTO fields must match the Entity fields.
* DTO must be used for all incoming and outgoing API data.

### **Code Sample (TxnItemMtsDTO.java)**

```
package com.siliconmount.ssrpro.dto;

import com.siliconmount.ssrpro.entity.TxnItemsEntity;

public class TxnItemMtsDTO {

    private Integer id;
    private Integer srNo;
    private String description;
    private Double quantity;
    private Double number;
    private Double length;
    private Double width;
    private Double height;
    private String unit;
    private Integer fkTxnItemId; // Foreign key reference to TxnItem
    private Double multiplyNumber;
    private String floorLiftRise;
    private int refTxnItemId;
    private double refTxnItemPercentage;

    // Constructors
    public TxnItemMtsDTO() {
    }

    public TxnItemMtsDTO(Integer id, Integer srNo, String description, Double quantity, Double number, Double length, Double width, Double height, String unit, Integer fkTxnItemId, Double multiplyNumber, String floorLiftRise, int refTxnItemId, double refTxnItemPercentage) {
        this.id = id;
        this.srNo = srNo;
        this.description = description;
        this.quantity = quantity;
        this.number = number;
        this.length = length;
        this.width = width;
        this.height = height;
        this.unit = unit;
        this.fkTxnItemId = fkTxnItemId;
        this.multiplyNumber = multiplyNumber;
        this.floorLiftRise = floorLiftRise;
        this.refTxnItemId = refTxnItemId;
        this.refTxnItemPercentage = refTxnItemPercentage;
    }

    // Getters and Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSrNo() {
        return srNo;
    }

    public void setSrNo(Integer srNo) {
        this.srNo = srNo;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getQuantity() {
        return quantity;
    }

    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }

    public Double getNumber() {
        return number;
    }

    public void setNumber(Double number) {
        this.number = number;
    }

    public Double getLength() {
        return length;
    }

    public void setLength(Double length) {
        this.length = length;
    }

    public Double getWidth() {
        return width;
    }

    public void setWidth(Double width) {
        this.width = width;
    }

    public Double getHeight() {
        return height;
    }

    public void setHeight(Double height) {
        this.height = height;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public Integer getFkTxnItemId() {
        return fkTxnItemId;
    }

    public void setFkTxnItemId(Integer fkTxnItemId) {
        this.fkTxnItemId = fkTxnItemId;
    }

    public Double getMultiplyNumber() {
        return multiplyNumber;
    }

    public void setMultiplyNumber(Double multiplyNumber) {
        this.multiplyNumber = multiplyNumber;
    }

    public String getFloorLiftRise() {
        return floorLiftRise;
    }

    public void setFloorLiftRise(String floorLiftRise) {
        this.floorLiftRise = floorLiftRise;
    }

    public int getRefTxnItemId() {
        return refTxnItemId;
    }

    public void setRefTxnItemId(int refTxnItemId) {
        this.refTxnItemId = refTxnItemId;
    }

    public double getRefTxnItemPercentage() {
        return refTxnItemPercentage;
    }

    public void setRefTxnItemPercentage(double refTxnItemPercentage) {
        this.refTxnItemPercentage = refTxnItemPercentage;
    }

    @Override
    public String toString() {
        return "TxnItemMtsDTO{" +
                "id=" + id +
                ", srNo=" + srNo +
                ", description='" + description + '\'' +
                ", quantity=" + quantity +
                ", number=" + number +
                ", length=" + length +
                ", width=" + width +
                ", height=" + height +
                ", unit='" + unit + '\'' +
                ", fkTxnItemId=" + fkTxnItemId +
                ", multiplyNumber=" + multiplyNumber +
                ", floorLiftRise='" + floorLiftRise + '\'' +
                ", refTxnItemId=" + refTxnItemId +
                ", refTxnItemPercentage=" + refTxnItemPercentage +
                '}';
    }
}


```

---

## **4.2 Entity File**

### **Filename Structure**

```
<EntityName>Entity.java
```

### **Rules**

* Must map directly to the database table.
* Must contain proper JPA annotations: `@Entity`, `@Table`, `@Id`, `@Column`, etc.
* Column names must match the database exactly.
* Should not contain service or business logic.
* Must follow camelCase for variable names.

### **Code Sample (TxnItemMtsEntity.java)**

```
package com.siliconmount.ssrpro.entity;


import jakarta.persistence.*;

@Entity
@Table(name = "txn_item_mts")
public class TxnItemMtsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "sr_no")
    private Integer srNo;

    @Column(name = "description", length = 60)
    private String description;

    @Column(name = "quantity")
    private Double quantity;

    @Column(name = "number")
    private Double number;

    @Column(name = "lenght")
    private Double length;

    @Column(name = "width")
    private Double width;

    @Column(name = "hight")
    private Double height;

    @Column(name = "unit", length = 45)
    private String unit;

    @Column(name = "fk_item_id")
    private Integer fkTxnItemId;

    @Column(name = "multiply_number")
    private Double multiplyNumber;

    @Column(name="floor_lift_rise")
    private String floorLiftRise;

    @Column(name = "ref_txn_item_id")
    private int refTxnItemId;

    @Column(name = "ref_txn_item_percentage")
    private double refTxnItemPercentage;

    // Getters and Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSrNo() {
        return srNo;
    }

    public void setSrNo(Integer srNo) {
        this.srNo = srNo;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getQuantity() {
        return quantity;
    }

    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }

    public Double getNumber() {
        return number;
    }

    public void setNumber(Double number) {
        this.number = number;
    }

    public Double getLength() {
        return length;
    }

    public void setLength(Double length) {
        this.length = length;
    }

    public Double getWidth() {
        return width;
    }

    public void setWidth(Double width) {
        this.width = width;
    }

    public Double getHeight() {
        return height;
    }

    public void setHeight(Double height) {
        this.height = height;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public Integer getFkTxnItemId() {
        return fkTxnItemId;
    }

    public void setFkTxnItemId(Integer fkTxnItemId) {
        this.fkTxnItemId = fkTxnItemId;
    }

    public Double getMultiplyNumber() {
        return multiplyNumber;
    }

    public void setMultiplyNumber(Double multiplyNumber) {
        this.multiplyNumber = multiplyNumber;
    }

    public String getFloorLiftRise() {
        return floorLiftRise;
    }

    public void setFloorLiftRise(String floorLiftRise) {
        this.floorLiftRise = floorLiftRise;
    }

    public int getRefTxnItemId() {
        return refTxnItemId;
    }

    public void setRefTxnItemId(int refTxnItemId) {
        this.refTxnItemId = refTxnItemId;
    }

    public double getRefTxnItemPercentage() {
        return refTxnItemPercentage;
    }

    public void setRefTxnItemPercentage(double refTxnItemPercentage) {
        this.refTxnItemPercentage = refTxnItemPercentage;
    }
}


```

---

## **4.3 Mapper File**

### **Filename Structure**

```
<EntityName>Mapper.java
```

### **Rules**

* Must use **MapStruct** for entity-to-DTO and DTO-to-entity conversion.
* Must contain:

  * `toDTO(Entity)`
  * `toEntity(DTO)`
  * `toEntity(DTO, @MappingTarget Entity)` for partial updates
* No manual mapping is allowed anywhere else.
* Mapper name must match the entity name.

### **Code Sample (TxnItemMtsMapper.java)**

```
package com.siliconmount.ssrpro.mapper;


import com.siliconmount.ssrpro.dto.MasterMaterialsRateDTO;
import com.siliconmount.ssrpro.dto.TxnItemMtsDTO;
import com.siliconmount.ssrpro.entity.MasterMaterialsRateEntity;
import com.siliconmount.ssrpro.entity.TxnItemMtsEntity;
import com.siliconmount.ssrpro.entity.TxnItemsEntity;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface TxnItemMtsMapper {

        TxnItemMtsMapper INSTANCE = Mappers.getMapper(TxnItemMtsMapper.class);

        TxnItemMtsDTO toDTO(TxnItemMtsEntity entity);

        @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
        TxnItemMtsEntity toEntity(TxnItemMtsDTO dto, @MappingTarget TxnItemMtsEntity txnItemMtsEntity);

        TxnItemMtsEntity toEntity(TxnItemMtsDTO dto);

}

```

---

## **4.4 Repository File**

### **Filename Structure**

```
<EntityName>Repository.java
```

### **Rules**

* Must extend `JpaRepository<Entity, ID>`.
* Custom queries must use `@Query` and `@Param`.
* Repository should not contain business logic.
* All DB interactions must go through the repository.

### **Code Sample (TxnItemMtsRepository.java)**

```
package com.siliconmount.ssrpro.repository;

import com.siliconmount.ssrpro.entity.TxnItemMtsEntity;
import com.siliconmount.ssrpro.entity.TxnSubworkEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TxnItemMtsRepository extends JpaRepository<TxnItemMtsEntity, Integer> {

    @Query(value = "SELECT * FROM txn_item_mts WHERE fk_item_id = :itemId", nativeQuery = true)
    List<TxnItemMtsEntity> findByItemId(@Param("itemId") Integer itemId);
}


```

---

## **4.5 Service File**

### **Filename Structure**

```
<EntityName>Service.java
```

### **Rules**

* Must contain all business logic.
* Must use Mapper for all conversions.
* Service must return DTOs, not Entities.
* CRUD operations must be clean and reusable.
* Service name must match entity name.

### **Code Sample (TxnItemMtsService.java)**

```
package com.siliconmount.ssrpro.service;

import com.siliconmount.ssrpro.dto.TxnItemMtsDTO;
import com.siliconmount.ssrpro.dto.TxnSubworkDTO;
import com.siliconmount.ssrpro.entity.TxnItemMtsEntity;
import com.siliconmount.ssrpro.entity.TxnSubworkEntity;
import com.siliconmount.ssrpro.mapper.TxnItemMtsMapper;
import com.siliconmount.ssrpro.mapper.TxnSubworkMapper;
import com.siliconmount.ssrpro.repository.TxnItemMtsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TxnItemMtsService {

    @Autowired
    private TxnItemMtsRepository repository;

    @Autowired
    TxnItemMtsMapper mapper;

    public List<TxnItemMtsDTO> getAllTxnItems() {


        return repository.findAll().stream()
                .map(mapper::toDTO)
                .collect(Collectors.toList());
    }

    public TxnItemMtsDTO getTxnItemById(Integer id) {
        TxnItemMtsEntity entity = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Item not found with ID: " + id));
        return mapper.toDTO(entity);
    }

    public TxnItemMtsDTO createTxnItem(TxnItemMtsDTO txnItemDTO) {
        TxnItemMtsEntity entity = mapper.toEntity(txnItemDTO);
        return mapper.toDTO(repository.save(entity));
    }

    public TxnItemMtsDTO updateTxnItem(Integer id, TxnItemMtsDTO txnItemDTO) {
        if (!repository.existsById(id)) {
            throw new RuntimeException("Item not found with ID: " + id);
        }
        txnItemDTO.setId(id); // Ensure the entity has the correct ID
        TxnItemMtsEntity txnItemMtsEntity = repository.getById(id);
        mapper.toEntity(txnItemDTO, txnItemMtsEntity);
        TxnItemMtsEntity updatedEntity = repository.save(txnItemMtsEntity);
        return mapper.toDTO(updatedEntity);
    }

    public String deleteTxnItem(Integer id) {
        if (!repository.existsById(id)) {
            throw new RuntimeException("Item not found with ID: " + id);
        }
        repository.deleteById(id);
        return "successfully deleted";
    }

    public List<TxnItemMtsDTO> getTxnItemByItemId(Integer itemId) {
        List<TxnItemMtsEntity>  entity = repository.findByItemId(itemId);
        return entity.stream().map(mapper::toDTO).collect(Collectors.toList());
    }
}


```

---

## **4.6 Controller File**

### **Filename Structure**

```
<EntityName>Controller.java
```

### **Rules**

* Must expose API endpoints using proper HTTP methods.
* Must return `ResponseEntity` or DTOs.
* No business logic allowed in controller.
* CRUD method names should be meaningful and readable.
* Controller name must follow entity name.

### **Code Sample (TxnItemMtsService.java)**

```
package com.siliconmount.ssrpro.controller;

import com.siliconmount.ssrpro.dto.TxnItemMtsDTO;
import com.siliconmount.ssrpro.dto.TxnSubworkDTO;
import com.siliconmount.ssrpro.service.TxnItemMtsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/txn-items-mts")
public class TxnItemMtsController {

    @Autowired
    private TxnItemMtsService service;

    // 🔹 Get All Items
    @GetMapping
    public List<TxnItemMtsDTO> getAllTxnItems() {
        return service.getAllTxnItems();
    }

    // 🔹 Get Item by ID
    @GetMapping("/{id}")
    public ResponseEntity<TxnItemMtsDTO> getTxnItemById(@PathVariable Integer id) {
        return ResponseEntity.ok(service.getTxnItemById(id));
    }

    // 🔹 Create New Item
    @PostMapping
    public ResponseEntity<TxnItemMtsDTO> createTxnItem(@RequestBody TxnItemMtsDTO txnItemDTO) {
        return ResponseEntity.ok(service.createTxnItem(txnItemDTO));
    }

    // 🔹 Update Item
    @PutMapping("/{id}")
    public ResponseEntity<TxnItemMtsDTO> updateTxnItem(
            @PathVariable Integer id, @RequestBody TxnItemMtsDTO txnItemDTO) {
        return ResponseEntity.ok(service.updateTxnItem(id, txnItemDTO));
    }

    // 🔹 Delete Item
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTxnItem(@PathVariable Integer id) {
        return ResponseEntity.ok(service.deleteTxnItem(id));
    }

    @GetMapping("/ByItemId/{itemId}")
    public ResponseEntity<List<TxnItemMtsDTO>> getTxnItemByItemId(@PathVariable Integer itemId) {
        return ResponseEntity.ok(service.getTxnItemByItemId(itemId));
    }
}


```

---

# **Important Note**

This structure must be followed for **every** API.
No shortcuts, no custom naming, no mixing conventions.

---

---

# **CHAPTER 5 – API Testing, Debugging & Development Workflow Guidelines**

This chapter provides the complete guidelines for running the SSRpro backend locally, testing APIs, following the standard development workflow, and resolving common issues. Every intern must strictly follow these steps to ensure consistent backend development.

---

# **5.1 Running the Backend Application**

The SSRpro backend uses Spring profiles to run the application in different environments. Three profiles are available:

* **local** – for running the project on your local machine
* **dev** – development server environment
* **prod** – production environment

Interns must run the project **only** with the local profile.

### **Running the Application (Local Profile)**

Open the terminal in the project root directory and run:

```
$env:SPRING_PROFILES_ACTIVE="local"
mvn spring-boot:run
```

The above command tells Spring Boot to load all configuration from:

```
application-local.properties
```

This includes database credentials, port configuration, and other environment-specific settings.

### **Important Notes**

* Do not run `dev` or `prod` profiles locally.
* If any error occurs during startup, always check the console logs for exact error details.

---

# **5.2 API Testing Guidelines**

SSRpro uses **Swagger UI** for API testing.
No Postman or external tools are required.

### **Swagger URLs**

**Local Environment:**

```
https://localhost:8082/swagger-ui/swagger-ui/index.html
```

**Development Environment:**

```
https://24.101.103.87:8082/swagger-ui/swagger-ui/index.html#
```

**Production Environment:**

```
https://api-ssrpro.siliconmount.com/swagger-ui/swagger-ui/index.html#/
```

---

## **Using Swagger UI**

Swagger provides:

* List of all available APIs
* Request/response models
* Input body structure
* Try-out and live testing
* Error code display
* Authorization panel

If interns are new to Swagger, they can read the basics here:
[https://swagger.io/tools/swagger-ui/](https://swagger.io/tools/swagger-ui/)

---

## **Authorization Before Testing**

Most APIs require authentication, so interns must authorize themselves before accessing any protected endpoint.

### **Steps to Authorize:**

1. Open Swagger UI
2. Call the login API:

```
POST /api/auth/signin
```

3. Enter your assigned username and password
4. Copy the token received in the response
5. Click the **Authorize** button in the top-right corner of Swagger
6. Paste your token in the **Bearer <token>** field
7. Click "Authorize" to apply authentication

Now you can test all allowed APIs.

---

# **5.3 Standard Workflow for Development**

Every intern must strictly follow the project workflow to avoid unnecessary conflicts and maintain code quality.

### **Daily Development Flow**

```
pull(main) 
→ code 
→ test(local) 
→ review by senior 
→ pull(main again) 
→ commit 
→ push(your branch) 
→ notify senior for PR
```

---

## **Merge Conflict Handling**

Conflicts occur when your branch and the main branch have edited the same files.

### **Basic Rules**

* Always read both versions of conflicting code
* Merge carefully without overwriting existing functionality
* Do not modify or delete APIs that already exist
* Solve conflicts one file at a time
* Run the backend after resolving conflicts to ensure a successful build

---

## **Commit Discipline**

Interns must follow a strict commit format:

```
dd-mm-yyyy : firstname : message
```

Examples:

```
25-11-2025 : dhanashri : added mts api
25-11-2025 : amruta : fixed height/length calculation
```

Commit only after completing a meaningful task such as finishing one API.

---

# **5.4 Logging & Debugging**

Basic debugging knowledge is expected from all interns, but these points must be followed:

* Spring Boot prints detailed logs on startup and during runtime
* All exceptions show the exact failing class, method, and line number
* Follow the stacktrace from top to bottom
* Use breakpoints in IntelliJ for deeper debugging
* Do not use `System.out.println()` inside production code
* Rely on logs and service-level checks for debugging backend issues

---

# **5.5 Common Issues & Solutions**

### **1. Database Connection Failing**

Check the file:

```
src/main/resources/application-local.properties
```

Verify your credentials:

```
spring.datasource.username=yourUsername
spring.datasource.password=yourPassword
spring.datasource.url=jdbc:mysql://localhost:3306/sts_ssrpro
```

If the database is empty or missing tables, re-import:

```
src/DataBase/sts_ssrpro.sql
```

---

### **2. Table Mismatch**

Occurs when:

* SQL file was not imported correctly
* Columns do not match entity fields

Solution:
Re-import the database and ensure that entity fields match DB columns exactly.

---

### **3. Mapper Errors**

Common mapstruct issues include:

* Field type mismatch
* Missing entity fields
* NullValuePropertyMappingStrategy conflicts

Solution:
Check your DTO, Entity, and Mapper structure. Ensure proper method signatures.

---

### **4. Entity–DTO Conversion Issues**

Occurs when:

* Getters/setters are missing
* Wrong data type selected
* Field names do not match

---

### **5. CORS Issues**

Local development rarely faces this problem because controllers already include:

```
@CrossOrigin(origins = "*", maxAge = 3600)
```

If APIs fail due to CORS, ensure your browser is not blocking insecure content.

---

### **6. Build Failures**

Causes:

* Missing semicolon
* Wrong import
* Maven dependency version mismatch
* JDK mismatch
* Incorrect code merge

Solution:

* Rebuild project
* Refresh Maven
* Fix syntax errors
* Ensure Java 21 is active

---

# **5.6 Code Review Process**

Before pushing your branch code, a mandatory senior review is required.

### **A good review includes checking:**

* Correct file structure
* DTO, Entity, Mapper, Repository, Service, Controller format
* Naming conventions
* No console debugging statements
* Clean and readable code
* Proper exception handling
* No changes to existing stable APIs
* No duplicated or dead code

Once approved:

1. Pull the latest main
2. Resolve conflicts
3. Commit
4. Push to your branch
5. Inform senior to raise a Pull Request

---

# **5.7 Intern Responsibilities**

### **Technical Responsibilities**

* Always follow the project structure
* Write clean, consistent, and reviewed code
* Maintain your own branch properly
* Test your APIs before sending for review
* Do not modify main/master branch directly
* Follow commit formatting rules

### **Professional Responsibilities**

* Communicate clearly
* Follow deadlines
* Ask doubts whenever blocked
* Maintain your project documentation
* Be disciplined with code and reviews
* Respect team workflow & guidelines

---

---

