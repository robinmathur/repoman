export class Proforma {
  name: string;
  desc: string;
  creationDate: Date;

  constructor(name: string, desc: string, creationDate: Date){
    this.name = name;
    this.desc = desc;
    this.creationDate = creationDate;
  }
}
