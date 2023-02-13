package midProject1;

import java.util.*;

public class Main {
	
	StringJoiner joiner = new StringJoiner(", ");
	Scanner scan = new Scanner(System.in);
	Vector<karyawan> listKaryawan = new Vector<>();
	int managerCount = 0;
	int supervisorCount = 0;
	int adminCount = 0;
	
	public Main() {
		
		int menu = -1;
		
		do {
			System.out.println("");
			System.out.println("========= PT Meksiko =========");
            System.out.println("1. Insert Data Karyawan");
            System.out.println("2. View Data Karyawan");
            System.out.println("3. Update Data Karyawan");
            System.out.println("4. Delete Data Karyawan");
            System.out.println("0. Exit");
            System.out.println("==============================");
            System.out.println("");
            System.out.print("Masukkan Pilihan: ");
            
			try {
				menu = scan.nextInt();
				scan.nextLine();
				System.out.println("");
				
				switch(menu) {
				case 1:
					add();
					break;
				case 2:
					view();
					break;
				case 3:
					view();
					update();
					break;
				case 4:
					view();
					delete();
					break;
				case 0:
					System.out.println("Terima kasih sudah menggunakan Sistem Managemen Karyawan.");
					System.exit(0);
					break;
				default:
					System.out.println("Pilihan Invalid.");
					break;
				}
			} catch (InputMismatchException e) {
				System.out.println("");
				System.out.println("Pilihan harus angka bulat.");
				scan.nextLine();
			}
			
		}while(menu!=5);
		
	}

	public static void main(String[] args) {
		
		new Main();
	}
	
	public void add() {
		String name; String gender; String position; String code; int salary = 0;
		
        System.out.print("Input nama karyawan [>= 3]: ");
        name = scan.nextLine();
        
        while (!name.matches("[a-zA-Z\\s]+") || name.length() < 3) {
        	System.out.println("");
            System.out.println("Nama tidak valid.");
            System.out.println("");
            System.out.print("Input nama karyawan [>= 3]: ");
            name = scan.nextLine();
        }
        
        System.out.print("Input jenis kelamin [Laki-laki | Perempuan] (Case Sensitive): ");
        gender = scan.nextLine();
        
        while (!gender.equals("Laki-laki") && !gender.equals("Perempuan")) {
        	System.out.println("");
        	System.out.println("Jenis kelamin tidak valid.");
        	System.out.println("");
            System.out.print("Input jenis kelamin [Laki-laki | Perempuan] (Case Sensitive): ");
            gender = scan.nextLine();
        }

        System.out.print("Input jabatan [Manager | Supervisor | Admin] (Case Sensitive): ");
        position = scan.nextLine();
        
        while (!position.equals("Manager") && !position.equals("Supervisor") && !position.equals("Admin")) {
        	System.out.println("");
        	System.out.println("Jabatan tidak valid.");
        	System.out.println("");
            System.out.print("Input jabatan [Manager | Supervisor | Admin] (Case Sensitive): ");
            position = scan.nextLine();
        }
        
        code = employeeCodeGenerator.generateCode();
        
        switch (position) {
        case "Manager":
            salary = 8000000;
            managerCount++;
            break;
        case "Supervisor":
            salary = 6000000;
            supervisorCount++;
            break;
        case "Admin":
        	salary = 4000000;
        	adminCount++;
        	break;
        }
        
        karyawan karyawanBaru = new karyawan(code, name, gender, position, salary);
        
        listKaryawan.add(karyawanBaru);
        System.out.println("Berhasil menambahkan karyawan dengan id " + code);
        
        int managerBonus = (int) (10.0 / 100.0 * salary);
        int supervisorBonus = (int) (7.5 / 100.0 * salary);
        int adminBonus = (int) (5.0 / 100.0 * salary);
        
        if((managerCount - 1) % 3 == 0) {
            for(int i = 0; i < listKaryawan.size() - 1; i++) {
                karyawan karyawan = listKaryawan.get(i);
                if(karyawan.getPosition().equals("Manager")) {
                    int salaryTemp = karyawan.getSalary();
                    karyawan.setSalary(salaryTemp + managerBonus);
                }
            }
            for(int j = 0; j < listKaryawan.size() - 1; j++) {
                karyawan karyawan = listKaryawan.get(j);
                if(karyawan.getPosition().equals("Manager")) {
                    joiner.add(karyawan.getCode());
                }
            }
            if(joiner.length() != 0) {
            	System.out.println("Bonus sebesar 10% telah diberikan kepada karyawan dengan id " + joiner.toString());
            	System.out.println("");
            }
           
        } else if((supervisorCount - 1) % 3 == 0) {
            for(int i = 0; i < listKaryawan.size(); i++) {
                karyawan karyawan = listKaryawan.get(i);
                if(karyawan.getPosition().equals("Supervisor")) {
                    int salaryTemp = karyawan.getSalary();
                    karyawan.setSalary(salaryTemp + supervisorBonus);
                }
            }
            for(int j = 0; j < listKaryawan.size() - 1; j++) {
                karyawan karyawan = listKaryawan.get(j);
                if(karyawan.getPosition().equals("Supervisor")) {
                    joiner.add(karyawan.getCode());
                }
            }
            if(joiner.length() != 0) {
            	System.out.println("Bonus sebesar 7.5% telah diberikan kepada karyawan dengan id " + joiner.toString());
            	System.out.println("");
            }
        } else if((adminCount - 1) % 3 == 0) {
            for(int i = 0; i < listKaryawan.size() - 1; i++) {
                karyawan karyawan = listKaryawan.get(i);
                if(karyawan.getPosition().equals("Admin")) {
                    int salaryTemp = karyawan.getSalary();
                    karyawan.setSalary(salaryTemp + adminBonus);
                }
            }
            for(int j = 0; j < listKaryawan.size() - 1; j++) {
                karyawan karyawan = listKaryawan.get(j);
                if(karyawan.getPosition().equals("Admin")) {
                    joiner.add(karyawan.getCode());
                }
            }
            if(joiner.length() != 0) {
            	System.out.println("Bonus sebesar 5% telah diberikan kepada karyawan dengan id " + joiner.toString());
            	System.out.println("");
            }
        }
	}

	
	public void view() {
		if (listKaryawan.isEmpty()) {
		    System.out.println("Data karyawan kosong.");
		    return;
		}
		
		listKaryawan.sort(Comparator.comparing(karyawan::getName, String.CASE_INSENSITIVE_ORDER));
		
		 System.out.println("|----|-----------------|------------------------------|---------------|--------------|-------------|");
		 System.out.println("|No  |Kode Karyawan    |Nama Karyawan                 |Jenis Kelamin  |Jabatan       |Gaji Karyawan|");
		 System.out.println("|----|-----------------|------------------------------|---------------|--------------|-------------|");
		 for (int i = 0; i < listKaryawan.size(); i++) {
			 System.out.printf("|%4d|%17s|%30s|%15s|%14s|%13d|\n", 
					 i + 1, listKaryawan.get(i).getCode(), listKaryawan.get(i).getName(), 
					 listKaryawan.get(i).getGender(), listKaryawan.get(i).getPosition(), 
					 listKaryawan.get(i).getSalary());
		 }
		 System.out.println("|----|-----------------|------------------------------|---------------|--------------|-------------|");
	}
	
	public void update() {
		if (listKaryawan.isEmpty()) {
		    return;
		}
		
		String name; String gender; String position; String code; int salary = 0;
		
		System.out.print("Input nomor urutan karyawan yang ingin diupdate (Input 0 bila tidak ingin update): ");
		int index = scan.nextInt(); scan.nextLine();
		
		while(index < 0 || index > listKaryawan.size()) {
			System.out.println("");
			System.out.println("Nomor urutan tidak valid.");
			System.out.println("");
			System.out.print("Input nomor urutan karyawan yang ingin diupdate (Input 0 bila tidak ingin update): ");
			index = scan.nextInt(); scan.nextLine();
		}
		
		switch (index) {
        case 0:
        	return;
        }
		
        System.out.print("Input nama karyawan [>= 3] (Input 0 bila tidak ingin update): ");
        name = scan.nextLine();
        
        while (!name.matches("[a-zA-Z\\s]+") && name.length() < 3 && !name.equals("0")) {
        	System.out.println("");
            System.out.println("Nama tidak valid.");
            System.out.println("");
            System.out.print("Input nama karyawan [>= 3]: ");
            name = scan.nextLine();
        }
        
        System.out.print("Input jenis kelamin [Laki-laki | Perempuan] (Case Sensitive) (Input 0 bila tidak ingin update): ");
        gender = scan.nextLine();
        
        while (!gender.equals("Laki-laki") && !gender.equals("Perempuan") && !gender.equals("0")) {
        	System.out.println("");
        	System.out.println("Jenis kelamin tidak valid.");
        	System.out.println("");
            System.out.print("Input jenis kelamin [Laki-laki | Perempuan] (Case Sensitive): ");
            gender = scan.nextLine();
        }

        System.out.print("Input jabatan [Manager | Supervisor | Admin] (Case Sensitive) (Input 0 bila tidak ingin update): ");
        position = scan.nextLine();
        
        while (!position.equals("Manager") && !position.equals("Supervisor") && !position.equals("Admin") && !position.equals("0")) {
        	System.out.println("");
        	System.out.println("Jabatan tidak valid.");
        	System.out.println("");
            System.out.print("Input jabatan [Manager | Supervisor | Admin] (Case Sensitive): ");
            position = scan.nextLine();
        }
        
        code = listKaryawan.get(index-1).code;
        
        switch (gender) {
        case "0":
        	gender = listKaryawan.get(index-1).gender;
        	break;
        }
        
        switch (name) {
        case "0":
        	name = listKaryawan.get(index-1).name;
        	break;
        }
        
        switch (position) {
        case "0":
        	position = listKaryawan.get(index-1).position;
        	salary = listKaryawan.get(index-1).salary;
        	break;
        case "Manager":
            salary = 8000000;
            managerCount++;
            break;
        case "Supervisor":
            salary = 6000000;
            supervisorCount++;
            break;
        case "Admin":
        	salary = 4000000;
        	adminCount++;
        	break;
        }
        
        if (listKaryawan.get(index-1).position.equals("Manager")) {
            managerCount--;
        } else if (listKaryawan.get(index-1).position.equals("Supervisor")) {
            supervisorCount--;
        } else if (listKaryawan.get(index-1).position.equals("Admin")) {
            adminCount--;
        } 
        
        karyawan karyawanBaru = new karyawan(code, name, gender, position, salary);
        
        listKaryawan.set(index-1, karyawanBaru);
        System.out.println("Berhasil mengupdate karyawan dengan id " + code);
        
        int managerBonus = (int) (10.0 / 100.0 * salary);
        int supervisorBonus = (int) (7.5 / 100.0 * salary);
        int adminBonus = (int) (5.0 / 100.0 * salary);
        
        StringJoiner managerJoiner = new StringJoiner(", ");
        StringJoiner supervisorJoiner = new StringJoiner(", ");
        StringJoiner adminJoiner = new StringJoiner(", ");
        
        if((managerCount - 1) % 3 == 0) {
        	if(position.equals("Manager")) {
        		for(int i = 0; i < listKaryawan.size(); i++) {
                    karyawan karyawan = listKaryawan.get(i);
                    if (i == index-1) {
                        continue;
                    }
                    if(karyawan.getPosition().equals("Manager")) {
                        int salaryTemp = karyawan.getSalary();
                        karyawan.setSalary(salaryTemp + managerBonus);
                        managerJoiner.add(karyawan.getCode());
                    }
                }
                if(managerJoiner.length() != 0) {
                    System.out.println("Bonus sebesar 10% telah diberikan kepada karyawan dengan id " + managerJoiner.toString());
                    System.out.println("");
                }
        	}
        }
        
        if((supervisorCount - 1) % 3 == 0) {
        	if(position.equals("Supervisor")) {
        		for(int i = 0; i < listKaryawan.size(); i++) {
                    karyawan karyawan = listKaryawan.get(i);
                    if (i == index-1) {
                        continue;
                    }
                    if(karyawan.getPosition().equals("Supervisor")) {
                        int salaryTemp = karyawan.getSalary();
                        karyawan.setSalary(salaryTemp + supervisorBonus);
                        supervisorJoiner.add(karyawan.getCode());
                    }
                }
                if(supervisorJoiner.length() != 0) {
                    System.out.println("Bonus sebesar 7.5% telah diberikan kepada karyawan dengan id " + supervisorJoiner.toString());
                    System.out.println("");
                }
        	}
        }      
        
        if((adminCount - 1) % 3 == 0) {
        	if(position.equals("Admin")) {
        		for(int i = 0; i < listKaryawan.size(); i++) {
                    karyawan karyawan = listKaryawan.get(i);
                    if (i == index-1) {
                        continue;
                    }
                    if(karyawan.getPosition().equals("Admin")) {
                        int salaryTemp = karyawan.getSalary();
                        karyawan.setSalary(salaryTemp + adminBonus);
                        adminJoiner.add(karyawan.getCode());
                    }
                }
                if(supervisorJoiner.length() != 0) {
                    System.out.println("Bonus sebesar 7.5% telah diberikan kepada karyawan dengan id " + adminJoiner.toString());
                    System.out.println("");
                }
        	}
        }
	} 
	
	public void delete() {
		if (listKaryawan.isEmpty()) {
		    return;
		}
		
		System.out.print("Input nomor urutan produk yang ingin dihapus (Input 0 bila tidak ingin update): ");
		int index = scan.nextInt(); scan.nextLine();
		
		switch (index) {
        case 0:
        	return;
        }
		
		while(index > listKaryawan.size()) {
			System.out.println("");
            System.out.println("Nomor urutan tidak valid.");
            System.out.println("");
            System.out.print("Input nomor urutan produk yang ingin dihapus: ");
            index = scan.nextInt(); scan.nextLine();
		}
		
		String job = listKaryawan.get(index-1).position;
		
		if (job.equals("Admin")) {
	        adminCount--;
	    } else if (job.equals("Supervisor")) {
	        supervisorCount--;
	    } else if (job.equals("Manager")) {
	        managerCount--;
	    }
		
		listKaryawan.remove(index-1); 
	
		System.out.println("Produk telah dihapus!");
	}
}
