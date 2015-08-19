(function() {
  'use strict';
  
  var player = $('.audioplayer audio')[0],
      playerUI = $('.audioplayer');
  
  function secondsToHumanReadableTime(s) {
    var minutes = 0,
        seconds = 0;
    minutes = Math.floor(s / 60);
    seconds = Math.floor(s % 60);
    
    return minutes + ':' + (seconds < 10 ? '0' + seconds : seconds);
  }
  
  function initEvents() {
    //player events
    $(player).on('durationchange', function() {
      $('.audioplayer__duration', playerUI).attr('data-total', secondsToHumanReadableTime(player.duration));
    }).on('timeupdate', function() {
      $('.audioplayer__duration', playerUI).attr('data-current', secondsToHumanReadableTime(player.currentTime));
      
      var perc = (player.currentTime / player.duration) * 100;
      $('.audioplayer__trackbar-progress', playerUI).css('width', perc + '%');
    });
    
    //controls events
    $('.audioplayer__play-pause').on('click', function(e) {
      e.preventDefault();
      
      if($(this).hasClass('playing')) {
        $(this).removeClass('playing');
      }
      if(player.paused) {
        player.play();
        $(this).addClass('playing');
      } else {
        player.pause();
        $(this).removeClass('playing');
      }
    });
    $('.audioplayer__repeat').on('click', function(e) {
      e.preventDefault();
      
      if($(this).hasClass('active')) {
        $(this).removeClass('active');
      }
      
      player.loop = !player.loop;
      
      if(player.loop) {
        $(this).addClass('active');
      } else {
        $(this).removeClass('active');
      }
    });
    
    $('.audioplayer__prev, .audioplayer__next').on('click', function(e) {
      console.warning('Not implemented');
    });
  }
  
  function init() {
    $('.audioplayer__duration', playerUI).attr({ 'data-current': secondsToHumanReadableTime(0), 'data-total': '...' });
    $('.audioplayer__title', playerUI).text($(player).data('title')).attr('title', $(player).data('title'));
    $('.audioplayer__artist', playerUI).text($(player).data('artist')).attr('title', $(player).data('artist'));
    $('.audioplayer__trackbar-progress', playerUI).css('width', '0');
    
    initEvents();
  };
  
  init();
}());