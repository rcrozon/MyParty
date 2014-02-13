<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="fr" lang="fr"></html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset utf-8"/>
    <title>
        <?php echo $title_for_layout; ?>
    </title>
    <link rel="stylesheet/less" href="<?php echo $this->Html->url('/css/headerCss.css');?>">
        <?php echo $this->Html->script('less'); ?>  

</head>
<body>
 
    <div class="topbar">
        <a href="/" class="logo">
           <?php
     echo $this->Html->image('logo.png') ;
?>
        </a>
<ul class="account">
                        <?php if(AuthComponent::user('id')): ?>
                        <li><?php echo $this->Html->link("Se déconnecter",'/clients/logout'); ?></li>
                        <li><?php echo $this->Html->link("Mon compte",array('action'=>'edit','controller'=>'clients')); ?></li>
                         <li><?php echo $this->Html->link("Administration",array('action'=>'edit','controller'=>'clients')); ?></li>
                        <?php else: ?>   
                        <li><?php echo $this->Html->link("Se connecter",array('action'=>'login','controller'=>'clients')); ?></li>   
                        <li><?php echo $this->Html->link("S'inscrire",array('action'=>'signup','controller'=>'clients')); ?></li>
                        <?php endif; ?>
                    </ul>        <div class="topbar-inner">
            
            <div class="container">
               
               
            </div>            
        </div>        
    </div>
 
        <div class="container" style="padding-top:60px;">
                  <?php echo $content_for_layout; ?>
        </div>
 
</body>
<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.6.2/jquery.min.js"></script>
</html>