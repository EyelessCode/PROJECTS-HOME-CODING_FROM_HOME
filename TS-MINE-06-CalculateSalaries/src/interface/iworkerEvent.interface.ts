export interface IWorkerEvent{
    repositoryWork():number;
    atmWork():number;
    supervisorWork():number;
}

export interface IWorkerViewEvent{
    workerView():void;
    lineString():string;
}