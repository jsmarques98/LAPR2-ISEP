# OO Analysis #

The construction process of the domain model is based on the client specifications, especially the nouns (for _concepts_) and verbs (for _relations_) used. 

## Rationale to identify domain conceptual classes ##
To identify domain conceptual classes, start by making a list of candidate conceptual classes inspired by the list of categories suggested in the book "Applying UML and Patterns: An Introduction to Object-Oriented Analysis and Design and Iterative Development". 


### _Conceptual Class Category List_ ###

**Business Transactions**

* Test

---

**Transaction Line Itemss**

* Sample
* Report 

---

**Product/Service related to a Transaction or Transaction Line Item**

* Parameter
* Analysis

---


**Transaction Records**

* Report  

---  


**Roles of People or Organizations**

* Many Labs
* Client 
*  Administrador
* Receptionist
* Laboratiry coordinator
* Specialist doctor
* Medical lab technician
* Clinical chemistry Technologist 

----


**Places**

* Chemical laboratory
* Clinical analysis laboratories

----


**Noteworthy Events**

* Client going to clinical
* Chemical Analysis 
* Notify client with results 
* collection methods

---


**Physical Objects**

* Samples

----


**Descriptions of Things**

*  Type of test
* Category 
* Report 

---


**Catalogs**

* 

---


**Containers**

*  

---


**Elements of Containers**

*  

---


**Organizations**

* Company

---

**Other External/Collaborating Systems**

* 


---


**Records of finance, work, contracts, legal matters**

* Daily reports
* Covid reports 

---


**Financial Instruments**

*  

---


**Documents mentioned/used to perform some work/**

* Report 

---



###**Rationale to identify associations between conceptual classes**###

An association is a relationship between instances of objects that indicates a relevant connection and that is worth of remembering, or it is derivable from the List of Common Associations: 



| Concept (A) 		|  Association   	|  Concept (B) |
|----------	   		|:-------------:		|------:       |
| Company 	| performs | Test |
| Company	| conducts | TestType |
| Company | have | Clinic |
| Parameter   | presented under  | Category |
| Category     | created by | Administrator |
| Test  | requested by | Client |
| Test  | is of | TestType | 
| Sample | collect by | medical lab technician |
| Report | analyzed by | Clinical chemistry tecnologist |
| Report | written by | medical lab technician | 
| Report   | written by |  Specialist doctor |
| Report | written by | Laboratiry coordinator |  
| Report  | based on | test | 
| Report  | send to | Client |
| Administrator | specific | test |
| Administrator | categorize | test | 
| Receptionist | register | client |
| Receptionist | register | teste |
| Laboratiry coordinator | validetes | reports | 
| Clinical chemistry Technologist | receive | samples |
| Clinical chemistry Technologist | register the result | samples | 
| Chemical laboratory |  where is analysed the | Samples |
| Chemical laboratory| where is written the | report | 
| Clinical analysis laboratories | where is colected the | Samples |
| Daily reports | is done by | Daily reports |
|  Covid reports | is done by | somebody | 

 






## Domain Model

**Do NOT forget to identify concepts atributes too.**

**Insert below the Domain Model Diagram in a SVG format**

![DM.svg](DM.svg)





