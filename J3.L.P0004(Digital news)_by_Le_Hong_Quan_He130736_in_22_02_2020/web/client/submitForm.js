/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
function submitForm(action, name, value) {
    
    var form = document.getElementById('frm');
    form.action = action;
    for(let i=0;i<name.length;i++){
        let input=document.createElement('input');
        input.name=name[i];
        input.value=value[i];
        input.type='hidden';
        form.appendChild(input);
        
    }
    form.submit();
}


