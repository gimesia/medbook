// lifecycleLoggerMixin.js
import { onMounted, onUpdated, onUnmounted } from 'vue';

export function useLifecycleLogger() {
  onMounted(() => {
    console.log('Component mounted');
  });
  
  onUpdated(() => {
    console.log('Component updated');
  });
  
  onUnmounted(() => {
    console.log('Component unmounted');
  });
}
