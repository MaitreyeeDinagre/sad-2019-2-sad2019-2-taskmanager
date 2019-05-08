import { role } from './role.model';
import { profile } from './profile.model';
import { initiative } from './initiative.model';

export class employee {
    employeeid : number;
    employeename : string;
    employeedetails : string;
    employeerole : role;
    employeeprofile : profile;
    employeeinitiative : initiative;
    employeeroleid : number;
    employeeprofileid : number;
    employeeinitiativeid : number;
}