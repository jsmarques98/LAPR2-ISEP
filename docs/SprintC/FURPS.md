# Supplementary Specification (FURPS+)

## Functionality

_Specifies functionalities that:_

- _are common across several US/UC;_
- _are not related to US/UC, namely: Audit, Reporting and Security._



### Audits

### Localization
	* Language only in English, location being in England
### Email
	* Client may receive notifications by email (by whom, internal system? services like outlook,gmail?)
### Printing
	* There is no proof of any physical printing of date, everything is done in the application.
### Security
	* Authentication system
	* Everyone must be authenticated by a password.
	* Each access is given by roles, which are established by what the actors do in the system.
	* Only Specialist Doctor is allowed to access all client data.
	* Medical Lab Technicians, Specialist Doctor and Laboratory Coordinators have access to reports.
	* Administrator can modify ordering algorithm

### Workflow
In order for a report to be made there needs to be some pre accepted happenings: client must have been registered, called, samples must have been retrieved, delivered to the laboratory, a diagnosis made, a report in base of the diagnosis made and the approval of the report.


## Usability 

_Evaluates the user interface. It has several subcategories,
among them: error prevention; interface aesthetics and design; help and
documentation; consistency and standards._

### Documentation
 Those who use the application will have a manual in the application.

### Interface

The user interface must be simple, intuitive.

### Interface consistency
User interface must be consistent.

Sorting data:
A good practice is to always sort data when we present it to the users.
Moreover, if the user wants, at any time he can use another criterium/order 
to analyze the data.

## Reliability
_Refers to the integrity, compliance and interoperability of the software. The requirements to be considered are: frequency and severity of failure, possibility of recovery, possibility of prediction, accuracy, average time between failures._
The system should not fail more than 5 days in one year.

### Disaster recover possibility
 Whenever the system fails, there should be no data loss.

## Performance
_Evaluates the performance requirements of the software, namely: response time, start-up time, recovery time, memory consumption, CPU usage, load capacity and application availability._

Any interface between a user and the system shall have a maximum response time of 3 seconds. The system should start up in less than 10 seconds.
The application will be deployed to a machine with 8GB of RAM.


## Supportability
_The supportability requirements gathers several characteristics, such as:
testability, adaptability, maintainability, compatibility,
configurability, installability, scalability and more._ 

The application should run on all platforms for which there exists a Java Virtual Machine.

Language will be only in English.

Ordering algorithm to be defined by a file configuration
The ordering will consist in ordering clients data by number or by name.

## +

### Design Constraints

_Specifies or constraints the system design process. Examples may include: programming languages, software process, mandatory standards/patterns, use of development tools, class library, etc._
  

Software will be developed using the artefacts developed in Requirements.
Engineering as a reference, Object Oriented Design.


### Implementation Constraints

_Specifies or constraints the code or construction of a system such
such as: mandatory standards/patterns, implementation languages,
database integrity, resource limits, operating system._

Programming language - Java

Developers must use NetBeans or IntelliJ.
Graphical interface using JavaFX11.

Documentation using Javadocs,
CamelCase, 
Images use SVG, classes must use data serialization.

Jacoco to generate coding reports.
Testing coverage for quality control.
Unit Tests (with JUnit 4).


### Interface Constraints
_Specifies or constraints the features inherent to the interaction of the
system being developed with other external systems._

Language of the interface will be only in English since the localization is in English.

Sorting data:
A good practice is to always sort data when we present it to the users.
Moreover, if the user wants, at any time he can use another criterium/order 
to analyze the data.

### Physical Constraints

_Specifies a limitation or physical requirement regarding the hardware used to house the system, as for example: material, shape, size or weight._

The application will be deployed to a machine with 8GB of RAM.
