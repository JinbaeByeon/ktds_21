function MyClass(name,id){
    this.name=name;
    this.id=id;
}
MyClass.prototype.func = function(){
        alert("hi");
}
MyClass.prototype.print = function(){
    console.log(this.name);
    console.log(this.id);
}