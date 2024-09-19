class Producer extends Thread {
    Company c;

    Producer(Company c) {
        this.c = c;
    }

    public void run() {
        int i = 1;
        while (true) {
            c.produce_item(i);
            try {
                Thread.sleep(3000);
            } catch (Exception e) {
                System.out.println(e);
            }
            i++;
        }
    }
}

class Customer extends Thread {
    Company c;

    Customer(Company c) {
        this.c = c;
    }

    public void run() {
        while (true) {
            c.customer_item();
            try {
                Thread.sleep(2000);
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }
}

public class Company {
    int n;
    boolean itemProduced = false;

    synchronized public void produce_item(int n) {
        while (itemProduced) {
            try {
                wait();
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
        this.n = n;
        System.out.println("Producer produced: " + this.n);
        itemProduced = true;
        notify();
    }

    synchronized public void customer_item() {
        while (!itemProduced) {
            try {
                wait();
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
        System.out.println("Customer consumed: " + this.n);
        itemProduced = false;
        notify();
    }

    public static void main(String[] args) {
        Company c = new Company();
        Producer p = new Producer(c);
        Customer cons = new Customer(c);

        p.start();
        cons.start();
    }
}
