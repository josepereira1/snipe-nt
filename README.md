# snipe-nt

## Requirements:
- Java 8+;

## Run the application:

Download the [snipe-nt.jar](https://github.com/josepereira1/snipe-nt/releases/download/v1.0.0-beta/snipe-nt.jar) and run the following command:

```
java -jar snipe-nt.jar
```

## How to use:

- First type "help" to see all possible commands:
```
 help
```
```
Output:
...
COMMANDS:
add:    Add a new snipe to the list;
help:   Display this information;
list:   List the snipes;
remove: Remove a specific snipe by name;
reset:  Reset the list;
...
```
### Add Command:
This command will calculate what time you need to back up your troops to match the time of your enemy attack. It also will save this information in a list for you create more snipes.
```
>> add
Insert a name to the snipe: 
>> snipe_1
Insert the max time to cancel an attack or support (in minutes):
>> 10
Insert attack time "HH:MM:SS":
>> 11:11:11
Insert troops out time "HH:MM:SS":
>> 11:5:37
OUTPUT: 
=> name: snipe_1 || attackTime: 2023-11-18T11:11:11 || troopsOutTime: 2023-11-18T11:05:37 || troopsBackTime: 2023-11-18T11:08:24
>>
```

Explanation: 
- This means, we should send an attack or support with our troops to other village at 11:05:37 o'clock and back them at 11:08:24 o'clock to snipe the enemy attack at 11:11:11 o'clock.
- Note: the milliseconds of our attack or support (send of our troops) it is very important, because it defines the milliseconds time of troops return.
- You can create multipple snipes and managed the list created (list, remove, reset, ...).

### Add command (to add more snipes):
```
>> add
Insert a name to the snipe: 
>> snipe_2
Insert the max time to cancel an attack or support (in minutes):
>> 10
Insert attack time "HH:MM:SS":
>> 11:11:11
Insert troops out time "HH:MM:SS":
>> 11:7:43
OUTPUT: 
=> name: snipe_1 || attackTime: 2023-11-18T11:11:11 || troopsOutTime: 2023-11-18T11:05:37 || troopsBackTime: 2023-11-18T11:08:24
=> name: snipe_2 || attackTime: 2023-11-18T11:11:11 || troopsOutTime: 2023-11-18T11:07:43 || troopsBackTime: 2023-11-18T11:09:27
>>
```

After add your snipes, you could manage the list, like list, remove, reset, add more snipes, ...
