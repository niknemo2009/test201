package lb2;

public enum WorkPosition {
    DIRECTOR(30, 100){
        @Override
        void Salary(int salary){
            this.salary = salary;

        }
    },
    ARTDIRECTOR(100, 50){
        @Override
        void Salary(int salary){
            this.salary = salary;

        }
    },
    EXEDIRECTOR(0, 200){
        @Override
        void Salary(int salary){
            this.salary = salary;

        }
    },
    WORKER(){
        @Override
        void Salary(int salary){
            this.salary = salary;
        }
    };

    int salary = 0;
    int vacation = 0;

    WorkPosition(int vacation, int salary){
        this.vacation = vacation;
        this.salary = salary;
    }
    WorkPosition(){

    }
    abstract void Salary(int salary);


}
