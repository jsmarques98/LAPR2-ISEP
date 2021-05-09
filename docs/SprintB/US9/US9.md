# US 9 - Specify new type of test and its collecting methods

## 1. Requirements Engineering

### 1.1. User Story Description

As an administrator, I want to specify a new type of test and its collecting methods.

### 1.2. Customer Specifications and Clarifications 

 - When the administrator specifies a new type of test, the administrator also specifies the method to collect a sample. The administrator introduces a brief description for the collecting method. 
 - Name: is a string with no more than 10 characters
 - Code: are five alphanumeric characters. The code is unique and is not automatically generated.
 - Both attributes are mandatory.

### 1.3. Acceptance Criteria

A new type of test and its collecting method will be created.

### 1.4. Found out Dependencies


### 1.5 Input and Output Data

The test type information for validation, and if the specification was successfull.

### 1.6. System Sequence Diagram (SSD)

![US9-SSD](US9-SSD.svg)


### 1.7 Other Relevant Remarks


## 2. OO Analysis

### 2.1. Relevant Domain Model Excerpt 

![US9-MD](US9-MD.svg)

### 2.2. Other Remarks

## 3. Design - User Story Realization 

### 3.1. Rationale

**The rationale grounds on the SSD interactions and the identified input/output data.**

| Interaction ID | Question: Which class is responsible for... | Answer  | Justification (with patterns)  |
|:-------------  |:--------------------- |:------------|:---------------------------- |
| Step 1  		 |	... instantiating a new TestType?	 |   Administrator          |  Creator: Receptionist records instances of Clients           |
| Step 2  		 |		n/a					 |             |                              |
| Step 3  		 |	... saving the input data?		 |      TestType       | IE: The object created in step 1 has its own data                             |
| Step 4.1  		 |	... validating the data locally?						 |    TestType         | IE: knows its own data                             |
| Step 4.2  		 |	... validating the data globally?						 |    Company         | IE: knows all TestType objects                             |
| Step 5  		 |	... saving the created TestType?						 |    Company         |    IE: records all TestType objects                          |
| Step 6  		 |	... informing operation success?						 |       UI      |    IE: responsible for user interaction                         |              

### Systematization ##

According to the taken rationale, the conceptual classes promoted to software classes are: 

 * TestType
 * Company
 * Administrator

Other software classes (i.e. Pure Fabrication) identified: 
 * RegisterTestTypeUI
 * RegisterTestTypeController

## 3.2. Sequence Diagram (SD)

![US9-SD](US9-SD.svg)

## 3.3. Class Diagram (CD)

![US9-CD](US9-CD.svg)

# 4. Tests 
*In this section, it is suggested to systematize how the tests were designed to allow a correct measurement of requirements fulfilling.* 

**_DO NOT COPY ALL DEVELOPED TESTS HERE_**

**Test 1:** Check that it is not possible to create an instance of the Example class with null values. 

	@Test(expected = IllegalArgumentException.class)
		public void ensureNullIsNotAllowed() {
		Exemplo instance = new Exemplo(null, null);
	}

*It is also recommended to organize this content by subsections.* 

# 5. Construction (Implementation)

*In this section, it is suggested to provide, if necessary, some evidence that the construction/implementation is in accordance with the previously carried out design. Furthermore, it is recommeded to mention/describe the existence of other relevant (e.g. configuration) files and highlight relevant commits.*

*It is also recommended to organize this content by subsections.* 

# 6. Integration and Demo 

*In this section, it is suggested to describe the efforts made to integrate this functionality with the other features of the system.*


# 7. Observations

*In this section, it is suggested to present a critical perspective on the developed work, pointing, for example, to other alternatives and or future related work.*





