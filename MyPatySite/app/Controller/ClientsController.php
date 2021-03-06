<?php
class ClientsController extends AppController{
     
    function signup(){
        $this->layout = 'login';
        if($this->request->is('post')){
            $d = $this->request->data; 
            $d['Client']['id'] = null;
            $d['Client']['lastlogin'] = '2009-08-08 12:17:00'; 
            if(!empty($d['Client']['password'])){
                $d['Client']['password'] = Security::hash($d['Client']['password'],null,true);
            }
            if($this->Client->save($d,true,array('username','password','mail','first_name','last_name'))){
            /*    $link = array('controller'=>'users','action
            '=>'activate',$this->User->id.'-'.md5($d['User']['password']));
                App::uses('CakeEmail','Network/Email'); 
                $mail = new CakeEmail(); 
                $mail->from('noreply@localhost.com')
                    ->to($d['User']['mail'])
                    ->subject('Test :: Inscription')
                    ->emailFormat('html')
                    ->template('signup')
                    ->viewVars(array('username'=>$d['User']['username'],'link'=>$link))
                    ->send();*/
                $this->Session->setFlash("Votre compte a bien été créé","notif");
                $this->request->data = array(); 
            }else{
                $this->Session->setFlash("Merci de corriger vos erreurs","notif",array('type'=>'error'));
            }
        }
    }
 
    function login(){
        $this->layout = 'login';
        if($this->request->is('post')){
            if($this->Auth->login()){
                $this->User->id =  $this->Auth->user("id");
                //$this->User->saveField('lastlogin',date('Y-m-d H:i:s')); 
                $this->Session->setFlash("Vous êtes maintenant connecté","notif");
                $this->redirect('/');
            }else{
                $this->Session->setFlash("Identifiants incorrects","notif",array('type'=>'error'));
            }
        }
    }
 
    function membre_index(){
         
    }
 
 
    function logout(){
        $this->Auth->logout(); 
        $this->redirect($this->referer());
    }
 
    function activate($token){
        $token = explode('-',$token); 
        $user = $this->User->find('first',array(
            'conditions' => array('id' => $token[0],'MD5(User.password)' => $token[1],'active' => 0)
        )); 
        if(!empty($user)){
            $this->User->id = $user['User']['id']; 
            $this->User->saveField('active',1); 
            $this->Session->setFlash("Votre compte a bien été activé","notif");
            $this->Auth->login($user['User']); 
        }else{
            $this->Session->setFlash("Ce lien d'activation n'est pas valide","notif",array('type'=>'error'));
        }
        $this->redirect('/'); 
        die(); 
    }
 
    function password(){
        if(!empty($this->request->params['named']['token'])) {
            $token = $this->request->params['named']['token']; 
            $token = explode('-',$token); 
            $user = $this->User->find('first',array(
                'conditions' => array('id' => $token[0],'MD5(User.password)' => $token[1],'active' => 1)
            )); 
            if($user){
                $this->User->id = $user['User']['id']; 
                $password = substr(md5(uniqid(rand(),true)),0,8); 
                $this->User->saveField('password',Security::hash($password,null,true));
                $this->Session->setFlash("Votre mot de passe a bien été réinitialisé, voici votre nouveau mot de passe : $password","notif");
            }else{
                $this->Session->setFlash("Le lien n'est pas valide","notif",array('type'=>'error'));
            }
        } 
 
        if($this->request->is('post')){
            $v = current($this->request->data); 
            $user = $this->User->find('first',array(
                'conditions' => array('mail'=>$v['mail'],'active'=>1)
            ));
            if(empty($user)){
                $this->Session->setFlash("Aucun utilisateur ne correspond à ce mail","notif",array('type'=>'error'));
            }else{
                App::uses('CakeEmail','Network/Email');
                $link = array('controller'=>'users','action'=>'password','token' => $user['User']['id'].'-'.md5($user['User']['password']));
                $mail = new CakeEmail();
                $mail->from('noreply@localhost.com')
                    ->to($user['User']['mail'])
                    ->subject('Test :: Mot de passe oublié')
                    ->emailFormat('html')
                    ->template('mdp')
                    ->viewVars(array('username'=>$user['User']['username'],'link'=>$link))
                    ->send();
            }
        }
         
    }
 
 
    function edit(){
        $user_id = $this->Auth->user('id');
        if(!$user_id){
            $this->redirect('/');
            die(); 
        }
        $this->User->id = $user_id; 
        $passError = false; 
        if($this->request->is('put') || $this->request->is('post')){
            $d = $this->request->data; 
            $d['User']['id'] = $user_id; 
            if(!empty($d['User']['pass1'])){
                if($d['User']['pass1']==$d['User']['pass2']){
                    $d['User']['password'] = Security::hash($d['User']['pass1'],null,true); 
                }else{
                    $passError = true;  
                }
            }
            if($this->User->save($d,true,array('firstname','lastname','password'))){
                $this->Session->setFlash("Votre profil a bien été édité","notif");
            }else{
                $this->Session->setFlash("Impossible de sauvegarder","notif",array('type'=>'error'));
            }
            if($passError) $this->User->validationErrors['pass2'] = array('Les mots de passe ne correspondent pas');
        }else{
            $this->request->data = $this->User->read(); 
        }
        $this->request->data['User']['pass1'] = $this->request->data['User']['pass2'] = ''; 
    }
 
}