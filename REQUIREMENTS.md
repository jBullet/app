# REQUIREMENTS


## PROJECT OVERVIEW AND OBJECTIVES
jBullet is a command line PIM(Personal Information Management) tool that is built around plugins? There are several task trackers and todo list, command line applications but none of which seem to offer extensibility out of the box? I would like to create an extensible PIM command line tool. The data model within the tool should be abstract enough to include all types of data and concrete enough to guide the development of useful plugins. A plugin architecture gives me the flexibility to create a task tracker today and add calendar and email functionally a year later without breaking current workflows.

## DEPENDENCIES
* Maven
* Java+8

## GOALS FOR THE MINIMUM VIABLE PRODUCT
A minimum viable product contains a simple API that allows for the creation of PIM tools. jBullet plugin manager should allow for the easy inclusion of plugins. It should also come out of the box with plugins that all for task management, this task manager should follow  GTD principles

## NON-FUNCTIONAL REQUIREMENTS
Compatible with systems other than Ubuntu is not a priority, The project will be built with Java and managed through Maven.  Plugins should be written in java. It is not a functional requirement to allow  for plugins to be written in languages other than Java

## CREATIVE REQUIREMENTS
This project should express the same values seen in projects like Maven and Vim. Plugins make jBullet extendable but batteries should be included. A basic set of plugins should come with the application, these plugins should need no configuration in the beginning and should be ready to use after installation.

## CONTENT REQUIREMENTS
PIM systems are data-driven applications, the way the application is used emerges from the type of data that is stored and the various ways this data can be organized.

## TRAINING AND DOCUMENTATION REQUIREMENTS
Since the application will be built around the data its stores a precise description of initially supported data types must be described.
