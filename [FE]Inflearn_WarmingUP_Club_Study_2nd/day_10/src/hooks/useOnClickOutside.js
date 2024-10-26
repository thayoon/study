import { useEffect } from "react";

export default function useOnClickOutside(ref, handler) {
  useEffect(() => {
    const listener = (event) => {
      if (!ref.current || ref.current.contains(event.target)) {
        return;
      }
      handler(event);
    };
    // mousedown, touchstart이 발생했을 때 listener 실행
    document.addEventListener("mousedown", listener);
    document.addEventListener("touchstart", listener);
    return () => {
      // 컴포넌트가 없어질 때 이것도 없애줌
      document.removeEventListener("mousedown", listener);
      document.removeEventListener("touchstart", listener);
    };
  }, [ref, handler]);
}
